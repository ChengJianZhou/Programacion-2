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
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Dec3_8 is
    Port (
        e : in std_logic;
        c : in std_logic_vector(2 downto 0);
        s : out std_logic_vector(7 downto 0)
    );
end entity Dec3_8;


architecture Dec3_8_Comportamiento of Dec3_8 is
begin
   
    process (e, c)
    begin
        if e = '0' then  
            case c is
                when "000" =>
                    s <= "11111110";  
                when "001" =>
                    s <= "11111101";
                when "010" =>
                    s <= "11111011";
                when "011" =>
                    s <= "11110111";
                when "100" =>
                    s <= "11101111";
                when "101" =>
                    s <= "11011111";
                when "110" =>
                    s <= "10111111";
                when "111" =>
                    s <= "01111111";
                when others =>
                    s <= "XXXXXXX";  
            end case;
        else
            s <= "11111111";  
        end if;
    end process;
end architecture Dec3_8_Comportamiento;
