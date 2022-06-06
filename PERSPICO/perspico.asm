.386
.model flat, stdcall
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;includem biblioteci, si declaram ce functii vrem sa importam
includelib msvcrt.lib
extern exit: proc
extern malloc: proc
extern memset: proc

includelib canvas.lib
extern BeginDrawing: proc
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;declaram simbolul start ca public - de acolo incepe executia
public start
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;sectiunile programului, date, respectiv cod
.data
;aici declaram date
deplasare DD 10
window_title DB "Exemplu proiect desenare",0 
area_width EQU 640
area_height EQU 480
area DD 0


pozitie DD 15,55,95,135
sir DD 1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,15
space DD 56
counter DD 0 ; numara evenimentele de tip timer

arg1 EQU 8
arg2 EQU 12
arg3 EQU 16
arg4 EQU 20

symbol_width EQU 20
symbol_height EQU 20
include digits.inc
include letters.inc

x_start equ 230
y_start equ 150
lungime_mare equ 160

.code
; procedura make_text afiseaza o litera sau o cifra la coordonatele date
; arg1 - simbolul de afisat (litera sau cifra)
; arg2 - pointer la vectorul de pixeli
; arg3 - pos_x
; arg4 - pos_y
make_text proc
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp+arg1] ; citim simbolul de afisat
	cmp eax, 'A'
	jl make_digit
	cmp eax, 'Z'
	jg make_digit
	sub eax, 'A'
	lea esi, letters
	jmp draw_text
make_digit:
	cmp eax, '0'
	jl make_space
	cmp eax, '10'
	jg make_space
	sub eax, '0'
	lea esi, digits
	jmp draw_text
make_space:	
	mov eax, 26 ; de la 0 pana la 25 sunt litere, 26 e space
	lea esi, letters
	
draw_text:
	mov ebx, symbol_width
	mul ebx
	mov ebx, symbol_height
	mul ebx
	add esi, eax
	mov ecx, symbol_height
bucla_simbol_linii:
	mov edi, [ebp+arg2] ; pointer la matricea de pixeli
	mov eax, [ebp+arg4] ; pointer la coord y
	add eax, symbol_height
	sub eax, ecx
	mov ebx, area_width
	mul ebx
	add eax, [ebp+arg3] ; pointer la coord x
	shl eax, 2 ; inmultim cu 4, avem un DWORD per pixel
	add edi, eax
	push ecx
	mov ecx, symbol_width
bucla_simbol_coloane:
	cmp byte ptr [esi], 0
	je simbol_pixel_alb
	mov dword ptr [edi], 0
	jmp simbol_pixel_next
simbol_pixel_alb:
	mov dword ptr [edi], 0FFFFFFh
simbol_pixel_next:
	inc esi
	add edi, 4
	loop bucla_simbol_coloane
	pop ecx
	loop bucla_simbol_linii
	popa
	mov esp, ebp
	pop ebp
	ret
make_text endp

; un macro ca sa apelam mai usor desenarea simbolului
make_text_macro macro symbol, drawArea, x, y
	push y
	push x
	push drawArea
	push symbol
	call make_text
	add esp, 16
endm



;macrou linie dreapta
line_horizontal macro x, y, len, color
local bucla_linie
	mov eax, y ; eax = y
	mov ebx, area_width
	mul ebx ; eax= y*area_width
	add eax, x ; eax =y*area_width + x
	shl eax, 2 ; eax = (y*area_width +x )*4
	add eax, area
    mov ecx, len
bucla_linie:
    mov dword ptr[eax], color
	add eax, 4
loop bucla_linie	

endm

;macrou linie verticala
line_vertictal macro x, y, len, color
local bucla_verticala
	mov eax, y ; eax = y
	mov ebx, area_width
	mul ebx ; eax= y*area_width
	add eax, x ; eax =y*area_width + x
	shl eax, 2 ; eax = (y*area_width +x )*4
	add eax, area
    mov ecx, len
bucla_verticala:
    mov dword ptr[eax], color
	add eax, area_width*4
loop bucla_verticala	

endm

; functia de desenare - se apeleaza la fiecare click
; sau la fiecare interval de 200ms in care nu s-a dat click
; arg1 - evt (0 - initializare, 1 - click, 2 - s-a scurs intervalul fara click)
; arg2 - x
; arg3 - y



draw proc
  
    
	push ebp
	mov ebp, esp
	pusha
	
	mov eax, [ebp+arg1]
	cmp eax, 1
	jz evt_click
	cmp eax, 2
	jz evt_timer ; nu s-a efectuat click pe nimic
	;mai jos e codul care intializeaza fereastra cu pixeli albi
	mov eax, area_width
	mov ebx, area_height
	mul ebx
	shl eax, 2
	push eax
	push 255
	push area
	call memset
	add esp, 12
	jmp afisare_litere
	
evt_click:

    
    mov eax, [ebp+arg2]
	cmp eax, x_start
	jl button_fail
	cmp eax, x_start + 40
	jg button_fail
	mov eax, [ebp+arg3]
	cmp eax, y_start
	jl button_fail
	cmp eax, y_start+40
	jg button_fail
	
	cmp sir[4], 16
	je c1
	cmp sir[16], 16
	je c1
	jmp button_fail
	
	c1:
	mov esi, 0
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 0

button_fail:
	
	mov eax, [ebp+arg2]
	cmp eax, x_start +40
	jl button_fail1
	cmp eax, x_start + 80
	jg button_fail1
	mov eax, [ebp+arg3]
	cmp eax, y_start
	jl button_fail1
	cmp eax, y_start+40
	jg button_fail1
	
	cmp sir[0], 16
	je c2
	cmp sir[8], 16
	je c2
	cmp sir[20], 16
	je c2
	jmp button_fail1
	
	c2:
	mov esi, 4
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 4
	
button_fail1:

mov eax, [ebp+arg2]
	cmp eax, x_start +80
	jl button_fail2
	cmp eax, x_start + 120
	jg button_fail2
	mov eax, [ebp+arg3]
	cmp eax, y_start
	jl button_fail2
	cmp eax, y_start+40
	jg button_fail2
	
	cmp sir[4], 16
	je c3
	cmp sir[12], 16
	je c3
	cmp sir[24], 16
	je c3
	jmp button_fail2
	
	c3:
	mov esi, 8
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 8
	
button_fail2:

mov eax, [ebp+arg2]
	cmp eax, x_start +120
	jl button_fail3
	cmp eax, x_start +160
	jg button_fail3
	mov eax, [ebp+arg3]
	cmp eax, y_start
	jl button_fail3
	cmp eax, y_start+40
	jg button_fail3
	
	cmp sir[8], 16
	je c4
	cmp sir[28], 16
	je c4
	jmp button_fail3
	
	c4:
	mov esi, 12
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 12
	
button_fail3:

    mov eax, [ebp+arg2]
	cmp eax, x_start
	jl button_fail4
	cmp eax, x_start + 40
	jg button_fail4
	mov eax, [ebp+arg3]
	cmp eax, y_start +40
	jl button_fail4
	cmp eax, y_start +80
	jg button_fail4
	
	cmp sir[0], 16
	je c5
	cmp sir[20], 16
	je c5
	cmp sir[32], 16
	je c5
	jmp button_fail4
	
	c5:
	mov esi, 16
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 16

button_fail4:

mov eax, [ebp+arg2]
	cmp eax, x_start+40
	jl button_fail5
	cmp eax, x_start + 80
	jg button_fail5
	mov eax, [ebp+arg3]
	cmp eax, y_start +40
	jl button_fail5
	cmp eax, y_start +80
	jg button_fail5
	
	cmp sir[4], 16
	je c6
	cmp sir[16], 16
	je c6
	cmp sir[24], 16
	je c6
	cmp sir[36], 16
	je c6
	jmp button_fail5
	
	c6:
	mov esi, 20
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 20

button_fail5:

mov eax, [ebp+arg2]
	cmp eax, x_start+80
	jl button_fail6
	cmp eax, x_start + 120
	jg button_fail6
	mov eax, [ebp+arg3]
	cmp eax, y_start +40
	jl button_fail6
	cmp eax, y_start +80
	jg button_fail6
	
	cmp sir[8], 16
	je c7
	cmp sir[20], 16
	je c7
	cmp sir[28], 16
	je c7
	cmp sir[40], 16
	je c7
	jmp button_fail6
	
	c7:
	mov esi, 24
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 24

button_fail6:

mov eax, [ebp+arg2]
	cmp eax, x_start+120
	jl button_fail7
	cmp eax, x_start + 160
	jg button_fail7
	mov eax, [ebp+arg3]
	cmp eax, y_start +40
	jl button_fail7
	cmp eax, y_start +80
	jg button_fail7
	
	cmp sir[12], 16
	je c8
	cmp sir[24], 16
	je c8
	cmp sir[44], 16
	je c8
	jmp button_fail7
	
	c8:
	mov esi, 28
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 28

button_fail7:

mov eax, [ebp+arg2]
	cmp eax, x_start
	jl button_fail8
	cmp eax, x_start + 40
	jg button_fail8
	mov eax, [ebp+arg3]
	cmp eax, y_start +80
	jl button_fail8
	cmp eax, y_start +120
	jg button_fail8
	
	cmp sir[16], 16
	je c9
	cmp sir[36], 16
	je c9
	cmp sir[48], 16
	je c9
	jmp button_fail8
	
	c9:
	mov esi, 32
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 32

button_fail8:

mov eax, [ebp+arg2]
	cmp eax, x_start+40
	jl button_fail9
	cmp eax, x_start + 80
	jg button_fail9
	mov eax, [ebp+arg3]
	cmp eax, y_start +80
	jl button_fail9
	cmp eax, y_start +120
	jg button_fail9
	
	cmp sir[20], 16
	je c10
	cmp sir[32], 16
	je c10
	cmp sir[52], 16
	je c10
	cmp sir[40], 16
	je c10
	jmp button_fail9
	
	c10:
	mov esi, 36
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 36

button_fail9:

mov eax, [ebp+arg2]
	cmp eax, x_start + 80
	jl button_fail10
	cmp eax, x_start + 120
	jg button_fail10
	mov eax, [ebp+arg3]
	cmp eax, y_start + 80
	jl button_fail10
	cmp eax, y_start + 120
	jg button_fail10
	
	cmp sir[24], 16
	je c11
	cmp sir[36], 16
	je c11
	cmp sir[56], 16
	je c11
	cmp sir[44], 16
	je c11
	jmp button_fail10
	
	c11:
	mov esi, 40
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 40

button_fail10:

mov eax, [ebp+arg2]
	cmp eax, x_start+ 120
	jl button_fail11
	cmp eax, x_start + 160
	jg button_fail11
	mov eax, [ebp+arg3]
	cmp eax, y_start +80
	jl button_fail11
	cmp eax, y_start +120
	jg button_fail11
	
	cmp sir[28], 16
	je c12
	cmp sir[40], 16
	je c12
	cmp sir[60], 16
	je c12
	jmp button_fail11
	
	c12:
	mov esi, 44
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 44

button_fail11:

mov eax, [ebp+arg2]
	cmp eax, x_start
	jl button_fail12
	cmp eax, x_start + 40
	jg button_fail12
	mov eax, [ebp+arg3]
	cmp eax, y_start +120
	jl button_fail12
	cmp eax, y_start +160
	jg button_fail12
	
	cmp sir[32], 16
	je c13
	cmp sir[52], 16
	je c13
	jmp button_fail12
	
	c13:
	mov esi, 48
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 48

button_fail12:

mov eax, [ebp+arg2]
	cmp eax, x_start+ 40
	jl button_fail13
	cmp eax, x_start + 80
	jg button_fail13
	mov eax, [ebp+arg3]
	cmp eax, y_start +120
	jl button_fail13
	cmp eax, y_start +160
	jg button_fail13
	
	cmp sir[48], 16
	je c14
	cmp sir[36], 16
	je c14
	cmp sir[56], 16
	je c14
	jmp button_fail13
	
	c14:
	mov esi, 52
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 52

button_fail13:

mov eax, [ebp+arg2]
	cmp eax, x_start+80
	jl button_fail14
	cmp eax, x_start + 120
	jg button_fail14
	mov eax, [ebp+arg3]
	cmp eax, y_start +120
	jl button_fail14
	cmp eax, y_start +160
	jg button_fail14
	
	cmp sir[52], 16
	je c15
	cmp sir[40], 16
	je c15
	cmp sir[60], 16
	je c15
	jmp button_fail14
	
	c15:
	mov esi, 56
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 56

button_fail14:

mov eax, [ebp+arg2]
	cmp eax, x_start+120
	jl button_fail15
	cmp eax, x_start + 160
	jg button_fail15
	mov eax, [ebp+arg3]
	cmp eax, y_start +120
	jl button_fail15
	cmp eax, y_start +160
	jg button_fail15
	
	cmp sir[56], 16
	je c16
	cmp sir[44], 16
	je c16
	jmp button_fail15
	
	c16:
	mov esi, 60
	mov eax, sir[esi]
	mov sir[esi], 16
	mov esi, space
	mov sir[esi], eax
	mov space, 60

button_fail15:

; verificarea daca s-a ajuns la solutie
    cmp sir[0], 1
    jne faill
	cmp sir[4], 2
	jne faill
	cmp sir[8], 3
    jne faill
	cmp sir[12], 4
	jne faill
	cmp sir[16], 5
    jne faill
	cmp sir[20], 6
	jne faill
	cmp sir[24], 7
    jne faill
	cmp sir[28], 8
	jne faill
	cmp sir[32], 9
    jne faill
	cmp sir[36], 10
	jne faill
	cmp sir[40], 11
    jne faill
	cmp sir[44], 12
	jne faill
	cmp sir[48], 13
    jne faill
	cmp sir[52], 14
	jne faill
	cmp sir[56], 15
    jne faill
    make_text_macro 'F', area, 210, 330
	make_text_macro 'E', area, 230, 330
	make_text_macro 'L', area, 250, 330
	make_text_macro 'I', area, 270, 330
	make_text_macro 'C', area, 290, 330
	make_text_macro 'I', area, 310, 330
	make_text_macro 'T', area, 330, 330
	make_text_macro 'A', area, 350, 330
	make_text_macro 'R', area, 370, 330
	make_text_macro 'I', area, 390, 330
	make_text_macro 'A', area, 240, 360
	make_text_macro 'I', area, 260, 360
	make_text_macro 'C', area, 300, 360
	make_text_macro 'A', area, 320, 360
	make_text_macro 'S', area, 340, 360
	make_text_macro 'T', area, 360, 360
	make_text_macro 'I', area, 380, 360
	make_text_macro 'G', area, 400, 360
	make_text_macro 'A', area, 420, 360
	make_text_macro 'T', area, 440, 360
	jmp correct
	
faill:	
    make_text_macro ' ', area, 210, 330
	make_text_macro ' ', area, 230, 330
	make_text_macro ' ', area, 250, 330
	make_text_macro ' ', area, 270, 330
	make_text_macro ' ', area, 290, 330
	make_text_macro ' ', area, 310, 330
	make_text_macro ' ', area, 330, 330
	make_text_macro ' ', area, 350, 330
	make_text_macro ' ', area, 370, 330
	make_text_macro ' ', area, 390, 330
	make_text_macro ' ', area, 240, 360
	make_text_macro ' ', area, 260, 360
	make_text_macro ' ', area, 300, 360
	make_text_macro ' ', area, 320, 360
	make_text_macro ' ', area, 340, 360
	make_text_macro ' ', area, 360, 360
	make_text_macro ' ', area, 380, 360
	make_text_macro ' ', area, 400, 360
	make_text_macro ' ', area, 420, 360
	make_text_macro ' ', area, 440, 360
correct:
    jmp afisare_litere
	
    	
evt_timer:
	inc counter
	
afisare_litere:
	;afisam valoarea counter-ului curent (sute, zeci si unitati)
	mov ebx, 10
	mov eax, counter
	;cifra unitatilor
	mov edx, 0
	div ebx
	add edx, '0'
	make_text_macro edx, area, 50, 10
	;cifra zecilor
	mov edx, 0
	div ebx
	add edx, '0'
	make_text_macro edx, area, 30, 10
	;cifra sutelor
	mov edx, 0
	div ebx
	add edx, '0'
	make_text_macro edx, area, 10, 10
	
    ;desenez tabela pe care vor fi afisate numerele

	 
	 line_horizontal x_start, y_start, lungime_mare, 0
	 line_horizontal x_start, y_start + lungime_mare -120, lungime_mare, 0
	 line_horizontal x_start, y_start + lungime_mare -80, lungime_mare, 0
	 line_horizontal x_start, y_start + lungime_mare -40, lungime_mare, 0
	 line_horizontal x_start, y_start + lungime_mare, lungime_mare, 0
	 line_horizontal x_start-1, y_start + lungime_mare+1, lungime_mare, 8f8f8fh
	 line_horizontal x_start-2, y_start + lungime_mare+2, lungime_mare, 8f8f8fh
	 line_horizontal x_start-3, y_start + lungime_mare+3, lungime_mare, 8f8f8fh
	 line_horizontal x_start-4, y_start + lungime_mare+4, lungime_mare, 8f8f8fh
	 line_horizontal x_start-5, y_start + lungime_mare+5, lungime_mare, 8f8f8fh
	 
	 line_vertictal x_start-5, y_start+5, lungime_mare,0
	 line_vertictal x_start-4, y_start+4, lungime_mare,0
	 line_vertictal x_start-3, y_start+3, lungime_mare,0
	 line_vertictal x_start-2, y_start+2, lungime_mare,0
	 line_vertictal x_start-1, y_start+1, lungime_mare,0 
	 line_vertictal x_start, y_start, lungime_mare, 0
	 line_vertictal x_start + lungime_mare -120, y_start, lungime_mare, 0
	 line_vertictal x_start + lungime_mare -80, y_start, lungime_mare, 0
	 line_vertictal x_start + lungime_mare -40, y_start, lungime_mare, 0
	 line_vertictal x_start + lungime_mare, y_start, lungime_mare, 0
	 
; afisare sir
     
	 
     mov edx, sir
	 add edx, '0'
	 make_text_macro edx, area, x_start +15, y_start +10
	 mov edx, sir+4
	 add edx, '0'
	 make_text_macro edx, area, x_start +55, y_start +10
	 mov edx, sir+8
	 add edx, '0'
	 make_text_macro edx, area, x_start +95, y_start +10
	 mov edx, sir+12
	 add edx, '0'
	 make_text_macro edx, area, x_start +135, y_start +10
	 mov edx, sir+16
	 add edx, '0'
	 make_text_macro edx, area, x_start +15, y_start +50
	 mov edx, sir+20
	 add edx, '0'
	 make_text_macro edx, area, x_start +55, y_start +50
	 mov edx, sir+24
	 add edx, '0'
	 make_text_macro edx, area, x_start +95, y_start +50
	 mov edx, sir+28
	 add edx, '0'
	 make_text_macro edx, area, x_start +135, y_start +50
	 mov edx, sir+32
	 add edx, '0'
	 make_text_macro edx, area, x_start +15, y_start +90
	 mov edx, sir+36
	 add edx, '0'
	 make_text_macro edx, area, x_start +55, y_start +90
	 mov edx, sir+40
	 add edx, '0'
	 make_text_macro edx, area, x_start +95, y_start +90
	 mov edx, sir+44
	 add edx, '0'
	 make_text_macro edx, area, x_start +135, y_start +90
	 mov edx, sir+48
	 add edx, '0'
	 make_text_macro edx, area, x_start +15, y_start +130
	 mov edx, sir+52
	 add edx, '0'
	 make_text_macro edx, area, x_start +55, y_start +130
	 mov edx, sir+56
	 add edx, '0'
	 make_text_macro edx, area, x_start +95, y_start +130
	 mov edx, sir+60
	 add edx, '0'
	 make_text_macro edx, area, x_start +135, y_start +130
	
	 
	
	 
final_draw:
	popa
	mov esp, ebp
	pop ebp
	ret
draw endp


	
start:
	;alocam memorie pentru zona de desenat
	mov eax, area_width
	mov ebx, area_height
	mul ebx
	shl eax, 2
	push eax
	call malloc
	add esp, 4
	mov area, eax
	;apelam functia de desenare a ferestrei
	; typedef void (*DrawFunc)(int evt, int x, int y);
	; void __cdecl BeginDrawing(const char *title, int width, int height, unsigned int *area, DrawFunc draw);
	push offset draw
	push area
	push area_height
	push area_width
	push offset window_title
	call BeginDrawing
	add esp, 20
	
	;terminarea programului
	push 0
	call exit
end start
