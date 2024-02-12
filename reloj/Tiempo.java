/**
* Reloj
* Definición de Tiempo
* @author Maria drp
*/

package reloj;

public class Tiempo {
        private int horas;
        private int minutos;
        private int segundos;
       

public Tiempo(int horas, int minutos, int segundos) {
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
    normalizarTiempo();
}

public String toString() {
    return this.horas + "h " + this.minutos + "m " + this.segundos + "s";
}

// Normaliza los valores de tiempo para evitar, por ejemplo, 90 minutos o 120 segundos
private void normalizarTiempo() {
    double minutosExtra = this.segundos / 60;
    this.segundos %= 60;
    this.minutos += minutosExtra;

    int horasExtra = this.minutos / 60;
    this.minutos %= 60;
    this.horas += horasExtra;
}

public Tiempo suma(Tiempo t) {
    return new Tiempo(this.horas + t.horas, this.minutos + t.minutos, this.segundos + t.segundos);
}

public Tiempo resta(Tiempo n) {
    int totalSegundos1 = this.horas * 3600 + this.minutos * 60 + this.segundos;
    int totalSegundos2 = n.horas * 3600 + n.minutos * 60 + n.segundos;
    int diferencia = totalSegundos1 - totalSegundos2;

    int horas = diferencia / 3600;
    int minutos = (diferencia % 3600) / 60;
    int segundos = diferencia % 60;

    // Asegurase que la diferencia no sea negativa
    if (horas < 0 || minutos < 0 || segundos < 0) {
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    return new Tiempo(horas, minutos, segundos);
}
public int getHour() {
    return this.horas;
}

public int getMinute() {
    return this.minutos;
}

public double getSecond() {
    return this.segundos;
}
}
    

