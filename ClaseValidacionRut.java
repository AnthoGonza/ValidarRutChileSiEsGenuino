/*
 *
 * Copyright (C) 2018 DesApli - Anthony Gonzales
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 *
 */
package global;

/**
 *
 * @author anthony gonzales
 */
public class ClaseValidacionRut {

    public ClaseValidacionRut() {
    }

    /*
    *VALIDANDO RUT
     */
    public boolean validarRut(String rut, String dig) {
        //RESULVARIABLE TADO
        boolean exito = false;
	//OBTENIENDO TAMAÑO DEL RUT
        int largo = rut.length();
	//CREANDO TAMAÑO DE ALMACENAMIENTO RUT
        int num[] = new int[largo];
        //ALMACENANDO RUT DIGITO POR DIGITO
        for (int i = 0; i < largo; i++) {
            num[i] = Integer.parseInt(rut.substring(i, i + 1));
        }
	//MULTIPLICANDO DE DERECHA A IZQUIERDA LOS NUMERO DE 2 AL 7
        int variable = 2;
        for (int i = largo-1; i >= 0; i--) {
            num[i] = num[i] * variable;
            variable++;
            if (variable > 7) {
                variable = 2;
            }
        }
	//SUMANDO TODA LA CADENA RESTANTE (MULTIPLICADA)
        int suma = 0;
        for (int i = 0; i < largo; i++) {
            suma = suma + num[i];
        }
        System.out.println("" + suma);
	//OBTENIENDO EL MODULO DE LA SUMA
        int resto = suma % 11;
        //OBTENIENDO DIGITO VERIFICADOR
        if (dv.equals("10")) {
            dv = "k";
        } else if (dv.equals("11")) {
            dv = "0";
        }
	//COMARANDO SI EL RUT INTRODUCIDO ES VERDADERO O NO
        if (dv.equals(dig.toLowerCase())) {
            exito = true;
        }
	//RETORNAMOS EL ESTADO DE LA COMPROBACION FINAL
        return exito;
    }
}
