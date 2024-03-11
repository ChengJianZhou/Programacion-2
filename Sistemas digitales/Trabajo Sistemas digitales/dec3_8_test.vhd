-------------------------------------------------------------------------------------------------------- 
--Este diseño es propiedad del autor y puede ser utilizado con fines de estudio 
-------------------------------------------------------------------------------------------------------- 
-- Proyecto:                    Practica 1 de Sistemas Digitales 
-- Diseño:                      Decodificador 3:8 con habilitacion 
-- Nombre del fichero:          .........vhd  
-- Autores:			Mateo Cuñaro Alfonsín y ChengJian Zhou	 
-- Fecha:		        26/02/2024
-- Version:		        1.0 
-- Resumen:	                Este fichero contiene una entidad y una arquitectura tipo comportamiento   
--                              de un Decodificador 3:8 con habilitacion. 

--                              Se utiliza el tipo de datos ............. para las señales.          
--         

-- Modificaciones: 
-- Fecha:26/02/2024
-- Autores: Mateo Cuñaro Alfonsín y ChengJian Zhou 
-- Version: 1.0 
-- Descripcion del cambio: Cambio en el programa

--=========================================================================================================
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;

ENTITY Test_Dec3_8 IS
END Test_Dec3_8;



ARCHITECTURE Test_Dec3_8_Estructural OF Test_Dec3_8 IS

     COMPONENT Dec3_8
          PORT(e: IN std_logic; c: IN std_logic_vector(2 DOWNTO 0); s: OUT std_logic_vector(7 DOWNTO 0));
     END COMPONENT;


     SIGNAL enable: std_logic;
     SIGNAL seleccion: std_logic_vector(2 DOWNTO 0);
     SIGNAL salidaactiva: std_logic_vector(7 DOWNTO 0);

BEGIN

     U0: Dec3_8 PORT MAP(e=>enable, c=>seleccion, s=>salidaactiva);

     enable<= '1', '0' AFTER 40 ns, 'X' AFTER 90 ns;
     seleccion<= "000", "001" AFTER 10 ns, "010" AFTER 20 ns, "011" AFTER 30 ns, "100" AFTER 40 ns, "101" AFTER 50 ns, "110" AFTER 60 ns, "111" AFTER 70 ns, "00X" AFTER 80 ns, "000" AFTER 90 ns;


END Test_Dec3_8_Estructural;
