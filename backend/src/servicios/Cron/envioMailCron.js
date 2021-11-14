import cron from 'node-cron';
import ServicioHoteles from '../servicios/servicioHoteles.js'

class envioMailCron {

    constructor() {
        this.servHoteles = new ServicioHoteles();
    }

    procesar(){
        cron.schedule('* * * * *', () => {
            //get all hoteles
            const hoteles = this.servHoteles.getAll();

            if(hoteles != undefined){
                hoteles.forEach(hotel => {
                
                    const reservas = hotel.reservas;
                    
                    reservas.forEach(reserva => {

                        if(reserva.estado == 'INACTIVO') {
                            const fechaInicio = reserva.inicio;
                            const diffTiempo = this.calcularRestanteEnHoras(fechaInicio);

                            if(diffTiempo <= 24) {
                                //se cambia el estado
                                //se envia mail
                            }

                        }
                        else if (reserva.estado == 'FINALIZADO') {
                            const fechaFin = reserva.fin;
                            const diffTiempo = this.calcularRestanteEnHoras(fechaFin);

                            if(diffTiempo <= 24) {
                                //se cambia el estado
                                //se envia mail
                            }
                        }
                    })

                });
            }

            
        })
    }

    calcularRestanteEnHoras(tiempo){
        const reservaTiempo = new Date(tiempo);
        const fechaAhora = new Date();

        const resta = reservaTiempo.getTime() - fechaAhora.getTime();
        const diffHoras = Math.round(resta / (1000 * 60 * 60));

        return diffHoras;

    }
}

export default envioMailCron