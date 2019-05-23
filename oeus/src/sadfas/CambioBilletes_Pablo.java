package sadfas;

import TandaExt.Consola;

public class CambioBilletes_Pablo {

	public static void main(String[] args) {
		final int N20=20, N10=20, N5=40, N2=50, N1=40;
		int cdinero, cdineroaux, billete20, billete10, billete5, moneda2, moneda1, n20, n10, n5, n2, n1, totalcaja;
		char resp;

		billete20=0;
		billete10=0;
		billete5=0;
		moneda2=0;
		moneda1=0;
		n20=N20;
		n10=N10;
		n5=N5;
		n2=N2;
		n1=N1;
		resp='S';
		totalcaja=(n20*20)+(n10*10)+(n5*5)+(n2*2)+(n1*1);
		while (totalcaja>=0 && (resp=='S'|| resp=='s'))
		{
			do
			{
				System.out.print("Introduzca la cantidad de dinero: ");
				cdinero=Consola.leeInt();
			}while (cdinero<0);
			if (cdinero>totalcaja)
			{
				System.out.println("No se puede entregar dicha cantidad (cantidad disponible: " + totalcaja + " €)");
			}
			else
			{
				cdineroaux=cdinero;
				while (cdineroaux!=0)
				{
					if (cdineroaux>=20 && n20!=0)
					{
						if (cdineroaux/20>n20)
						{
							billete20=n20;
							cdineroaux=cdineroaux-(billete20*20);
							n20-=billete20;
						}
						else
						{
							if (n20>=cdineroaux/20)
							{
								billete20+=cdineroaux/20;
								cdineroaux=cdineroaux%20;
								n20-=billete20;
							}
						}
					}
					else
					{
						if (cdineroaux>=10 && n10!=0)
						{
							if (cdineroaux/10>n10)
							{
								billete10=n10;
								cdineroaux=cdineroaux-(billete10*10);
								n10-=billete10;
							}
							else
							{
								if (n10>=cdineroaux/10)
								{
									billete10+=cdineroaux/10;
									cdineroaux=cdineroaux%10;
									n10-=billete10;
								}
							}
						}
						else
						{
							if (cdineroaux>=5&& n5!=0)
							{
								if (cdineroaux/5>n5)
								{
									billete5=n5;
									cdineroaux=cdineroaux-(billete5*5);
									n5-=billete5;
								}
								else
								{
									if (n5>=cdineroaux/5)
									{
										billete5+=cdineroaux/5;
										cdineroaux=cdineroaux%5;
										n5-=billete5;
									}
								}
							}
							else
							{
								if (cdineroaux>=2 && n2!=0)
								{
									if (cdineroaux/2>n2)
									{
										moneda2=n2;
										cdineroaux=cdineroaux-(moneda2*2);
										n2-=moneda2;
									}
									else
									{
										if (n2>=cdineroaux/2)
										{
											moneda2+=cdineroaux/2;
											cdineroaux=cdineroaux%2;
											n2-=moneda2;
										}
									}
								}
								else
								{
									if (cdineroaux/1>n1 && n1!=0)
									{
										moneda1=n1;
										cdineroaux=cdineroaux-(moneda1*1);
										n1-=moneda1;
									}
									else
									{
										if (n1>=cdineroaux/1)
										{
											moneda1+=cdineroaux/1;
											cdineroaux=cdineroaux%1;
											n1-=moneda1;
										}
									}
								}
							}
						}
					}	
				}
				totalcaja=(n20*20)+(n10*10)+(n5*5)+(n2*2)+(n1*1);
				System.out.println("Billetes de 20€: "+billete20);
				System.out.println("Billetes de 10€: "+billete10);
				System.out.println("Billetes de 5€: "+billete5);
				System.out.println("Monedas de 2€: "+moneda2);
				System.out.println("Monedas de 1€: "+moneda1);
			}
			if (totalcaja!=0)
			{
				billete20=0;
				billete10=0;
				billete5=0;
				moneda2=0;
				moneda1=0;
				System.out.print("¿Desea introducir otra cantidad? (S,s,N,n): ");
				resp=Consola.leeChar();
				while (resp!='N'&& resp!='n'&& resp!='S'&& resp!='s')
				{
					System.out.print("Valor fuera de rango, vuelva a introducir (S,s,N,n): ");
					resp=Consola.leeChar();
				}
			}
			else
			{
				System.out.println("Nos hemos quedado sin fondos");
				resp='N';
			}
		}
		System.out.println("Hasta pronto");
	}
}
