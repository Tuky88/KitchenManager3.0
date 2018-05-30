package modelo;

import javax.swing.JOptionPane;
public class Cheque
{
	private String nombre="",letra="",monto="";
	private int auxiliar=0;
	private int decena=0, mil=0;
	private String palabra="";
	public String generarCantidad(String num)
	{       palabra="";
		int numero=0;
		int longitud=num.length();
		int identificador=longitud;
		while(identificador!=0)
		{
                    
			char caracter=num.charAt(auxiliar);
		if(caracter=='.')
                {
                    break;
                }
                else
                {
                 numero=Integer.parseInt(caracter+"");
			palabra=identificacion(numero,identificador,num);
			identificador--;
			auxiliar++;   
                }
                        
		}
                auxiliar=0;
		return palabra;
                
	}
	public String identificacion(int numero,int identificador, String num)
	{
		switch(identificador)
		{
			case 1:
			{
				if(decena!=1)
				{
					if(numero==1)
						palabra+="uno ";
					if(numero==2)
						palabra+="dos ";
					if(numero==3)
						palabra+="tres ";
					if(numero==4)
						palabra+="cuatro ";
					if(numero==5)
						palabra+="cinco ";
					if(numero==6)
						palabra+="seis ";
					if(numero==6)
						palabra+="siete ";
					if(numero==8)
						palabra+="ocho ";
					if(numero==9)
						palabra+="nueve ";
				}
				break;
			}
			case 2:
			{
				if(numero==1)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="diez ";
					if(num.charAt(auxiliar+1)=='1')
						palabra+="once ";
					if(num.charAt(auxiliar+1)=='2')
						palabra+="doce ";
					if(num.charAt(auxiliar+1)=='3')
						palabra+="trece ";
					if(num.charAt(auxiliar+1)=='4')
						palabra+="catorce ";
					if(num.charAt(auxiliar+1)=='5')
						palabra+="quince ";
					if(num.charAt(auxiliar+1)=='6')
						palabra+="dieciseis ";
					if(num.charAt(auxiliar+1)=='7')
						palabra+="diecisiete ";
					if(num.charAt(auxiliar+1)=='8')
						palabra+="dieciocho ";
					if(num.charAt(auxiliar+1)=='9')
						palabra+="diecinueve "; 
					decena++;
					identificador=0;
				}
				if(numero==2)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="veinte ";
					else
						palabra+="veinti ";
				}
				if(numero==3)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="treinta ";
					else
						palabra+="treinta y ";
				}
				if(numero==4)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="cuarenta ";
					else
						palabra+="cuarenta y ";
				}
 				if(numero==5)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="cincuenta ";
					else
						palabra+="cincuenta y ";
				}
				if(numero==6)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="sesenta ";
					else
						palabra+="sesenta y ";
				}
				if(numero==7)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="setenta ";
					else
						palabra+="setenta y ";
				}
				if(numero==8)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="ochenta ";
					else
						palabra+="ochenta y ";
				}
				if(numero==9)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="noventa ";
					else
						palabra+="noventa y ";
				}
				break;
			}
			case 3:
			{
				if(numero==1)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="cien ";
					else
						palabra+="ciento ";
				}
				if(numero==2)
					palabra+="doscientos ";
				if(numero==3)
					palabra+="trescientos ";
				if(numero==4)
					palabra+="cuatrocientos ";
				if(numero==5)
					palabra+="quinientos ";
				if(numero==6)
					palabra+="seiscientos ";
				if(numero==7)
					palabra+="setecientos ";
				if(numero==8)
					palabra+="ochocientos ";
				if(numero==9)
					palabra+="novecientos ";
				break;
			}
			case 4:
			{
				if(mil!=1)
				{
					if(numero==1)
					{
						if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0'&&num.charAt(auxiliar+3)=='0')
							palabra+="mil";
						else
							palabra+="mil ";
					}
					if(numero==2)
						palabra+="dos mil ";
					if(numero==3)
						palabra+="tres mil ";
					if(numero==4)
						palabra+="cuatromil ";
					if(numero==5)
						palabra+="cincomil ";
					if(numero==6)
						palabra+="seismil ";
					if(numero==7)
						palabra+="sietemil ";
					if(numero==8)
						palabra+="ochomil ";
					if(numero==9)
						palabra+="nuevemil ";
				}
				break;
			}
			case 5:
			{
				if(numero==1)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="diez mil ";
					if(num.charAt(auxiliar+1)=='1')
						palabra+="once mil ";
					if(num.charAt(auxiliar+1)=='2')
						palabra+="doce mil ";
					if(num.charAt(auxiliar+1)=='3')
						palabra+="trece mil ";
					if(num.charAt(auxiliar+2)=='4')
						palabra+="catorce mil ";
					if(num.charAt(auxiliar+1)=='5')
						palabra+="quince mil ";
					if(num.charAt(auxiliar+1)=='6')
						palabra+="dieciseis mil ";
					if(num.charAt(auxiliar+1)=='7')
						palabra+="diecisiete mil ";
					if(num.charAt(auxiliar+1)=='8')
						palabra+="dieciocho mil ";
					if(num.charAt(auxiliar+1)=='9')
						palabra+="diecinueve mil ";
					mil++;
					identificador--;
				}
				if(numero==2)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="veinte mil ";
					else
						palabra+="veinti";
				}
				if(numero==3)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="treinta mil ";
					else
						palabra+="treinta y ";
				}
				if(numero==4)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="cuarenta mil ";
					else
						palabra+="cuarenta y ";
				}
				if(numero==5)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="cincuenta mil ";
					else
						palabra+="cincuenta y";
				}
				if(numero==6)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="sesenta mil ";
					else
						palabra+="sesenta y ";
				}
				if(numero==7)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="setenta mil ";
					else
						palabra+="setenta y ";
				}
				if(numero==8)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="ochenta mil ";
					else
						palabra+="ochenta y";
				}
				if(numero==9)
				{
					if(num.charAt(auxiliar+1)=='0')
						palabra+="noventa mil ";
					else
						palabra+="noventa y ";
				}
				break;
			}
			case 6:
			{
				if(numero==1)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="cien mil ";
					else
						palabra+="ciento ";
				}
				if(numero==2)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="doscientos mil ";
					else
						palabra+="doscientos  ";
				}
				if(numero==3)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="trescientos mil ";
					else
						palabra+="trescientos  ";
				}
				if(numero==4)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="cuatrocientos mil ";
					else
						palabra+="cuatrocientos  ";
				}
				if(numero==5)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="quinientos mil ";
					else
						palabra+="quinientos  ";
				}
				if(numero==6)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="seiscientos mil ";
					else
						palabra+="seiscientos  ";
				}
				if(numero==7)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="setecientos mil ";
					else
						palabra+="setecientos  ";
				}
				if(numero==8)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="ochocientos mil ";
					else
						palabra+="ochocientos  ";
				}
				if(numero==9)
				{
					if(num.charAt(auxiliar+1)=='0'&&num.charAt(auxiliar+2)=='0')
						palabra+="novecientos mil ";
					else
						palabra+="novecientos  ";
				}
				break;
			}
			case 7:
			{
				if(numero==1)
					palabra+="un millon ";
				if(numero==2)
					palabra+="dos millones ";
				if(numero==3)
					palabra+="tres millones ";
				if(numero==4)
					palabra+="cuatro millones ";
				if(numero==5)
					palabra+="cinco millones ";
				if(numero==6)
					palabra+="seis millones ";
				if(numero==7)
					palabra+="siete millones ";
				if(numero==8)
					palabra+="ocho millones ";
				if(numero==9)
					palabra+="nueve millones ";
				break;
			}
		}
	return palabra;	
	}
	public String getNombre(){
String nombre=JOptionPane.showInputDialog(null,"A nombre de quien?");
	return nombre;
	}
	public String getCantidad(){
	String cantidad;
	cantidad=JOptionPane.showInputDialog(null,"Cuanto?");
	if(Integer.parseInt(cantidad)>0){
	return cantidad;
	}
	else{
	JOptionPane.showMessageDialog(null,"No puedes depositar 0 pesos o menos");
	return "";
	}		
	}
	public void getCheque(){
nombre=getNombre();
monto=getCantidad();
letra=generarCantidad(monto);
	}
	
}