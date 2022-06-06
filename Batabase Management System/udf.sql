DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `minim`() RETURNS int(4)
RETURN (select durata from film
order by durata desc
LIMIT 1)$$
DELIMITER ;