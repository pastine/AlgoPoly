# AlgoPoly

## TP2 - Java 
## Grupo 7 - Corrector: Tomás Bustamante

### Links a documentos
+ Consigna: https://goo.gl/WxunNH
+ Informe: https://goo.gl/7Hr6yN
+ Debate: https://goo.gl/Wwq6Yr

### Integrantes

+ Medina, Jonathan
+ Manzano, Lautaro
+ Accini, Tomás
+ Pastine, Casimiro

### TO DO:
1ra Entrega (16 de Noviembre)
- [X] Agregar .gitignore para las clases compiladas
- [X] Set up de Travis para integración continua
- [X] Un jugador cae en Quini 6 por primera vez. Verificar que su capital se incrementa en $50000. 
- [X] Un jugador cae en Quini 6 por segunda vez. Verificar que su capital se incrementa en $30000.
- [X] Un jugador cae en Quini 6 más de dos veces. Verificar que su capital no se incrementa.
- [X] Un jugador cae en un Barrio, se adueña de este. Verificamos que este jugador es el propietario.
- [X] Un jugador cae en la Cárcel, no puede ejecutar una acción. Verificar que no puede desplazarse.
- [X] Un jugador cae en la Cárcel, puede pagar la fianza si el turno es 2 o 3. Verificar que luego de esto puede moverse.
- [X] Un jugador cae en la Cárcel, no puede pagar la fianza por falta de fondos siendo el turno es 2 o 3. Verificar que luego de esto no se puede moverse.
- [X] Un jugador cae en Avance dinámico habiendo sumado 2,3,4,5 o 6. Verificar que su posición es equivalente a avanzar dos casilleros menos que la suma obtenida.
- [X] Un jugador cae en Avance dinámico habiendo sumado 7,8,9 o 10. Verificar que su posición es equivalente a avanzar una #cantidad de efectivo del jugador % número sacado. 
- [X] Un jugador cae en Avance dinámico habiendo sumado 11 o 12. Verificar que su posición es equivalente a avanzar el número sacado menos la sumatoria de propiedades del jugador. 
- [X] Todas las pruebas pertinentes que permitan verificar el comportamiento de retroceso dinámico.
- [X] Un jugador cae en Policía. Verificar que no pueda desempeñar ninguna acción y que su ubicación sea ahora la Cárcel.



2da Entrega (23 de Noviembre)

- [ ] Un jugador cae en un barrio sin propietario y compra el barrio. Verificar que su dinero disponible se redujo por el precio del barrio. Replicar esto para cualquiera de los barrios.
- [ ] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y construye una casa. Verificar que su dinero disponible se decrementó en $5000.
- [ ] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 1 casa en el Sur y una en el Norte. Verificar que al caer un contrincante en esta área (sur o nortre) el dinero de este se reduce en un monto de $3000. 
- [ ] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 2 casa en el Sur y una en el Norte. Verificar que al caer un contrincante en esta área (sur o nortre) el dinero de este se reduce en un monto de $3500. 
- [ ] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte, no tiene cubierta la máxima capacidad de casas y construye una hotel. Verificar que su dinero disponible NO se decrementó. 
- [ ] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 2 casa en el Sur, dos casas en el Norte y construye una hotel. Verificar que su dinero disponible se decrementó en $8000. 
- [ ] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 2 casa en el Sur, dos casas en el Norte y construye una hotel. Verificar que al caer un contrincante en esta área el dinero de este se reduce en un monto de $5000.
- [ ] Agregar los mismos casos para Córdoba, Salta. 
- [ ] Un jugador cuenta con Santa Fé y construye una casa. Verificar que su dinero disponible se decrementó en $4000.
- [ ] Un jugador cae en un barrio con construcciones. Verificar que su dinero disponible reduzca en función del alquiler según la propiedad construida. Implementar esto para todos los barrios.
- [X] Un jugador cae en TRENES adquirida previamente por otro jugador que no se adueño de SUBTES. Verificar que su dinero se reduzca por 450 veces lo que dice los dados arrojados previamente.
- [X] Un jugador cae en TRENES adquirida previamente por otro jugador que además es el dueño de SUBTES. Verificar que su dinero se reduzca por 800 veces lo que dice los dados arrojados previamente.
- [ ] Un jugador intercambia una propiedad suya por otra propiedad de otro jugador. Verificar que un tercer jugador cae en el área y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad.
- [ ] Un jugador intercambia una propiedad suya por otra propiedad de otro jugador. Verificar que un tercer jugador cae en el área y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad por un monto igual al área sin construcción.
- [X] Un jugador cae en Impuesto al Lujo. Verificar que su dinero se reduzca un %10 de su efectivo.
- [ ] Un jugador cae en EDESUR adquirida previamente por otro jugador que no se adueño de AYSA. Verificar que su dinero se reduzca por 500 veces lo que dice los dados arrojados previamente. 
- [ ] Un jugador cae en EDESUR adquirida previamente por otro jugador que además es el dueño de AYSA. Verificar que su dinero se reduzca por 1000 veces lo que dice los dados arrojados previamente.
