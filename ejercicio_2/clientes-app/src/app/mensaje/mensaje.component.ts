import { Component, OnInit } from '@angular/core';
import { Mensaje } from './mensaje';
import { MensajeService } from './mensaje.service';

@Component({
  selector: 'app-mensaje',
  templateUrl: './mensaje.component.html',
  styleUrls: ['./mensaje.component.css']
})
export class MensajeComponent implements OnInit {
  
  mensaje: Mensaje;

  constructor(private mensajeService: MensajeService) { }

  ngOnInit() {
    this.mensajeService.getMensaje().subscribe(
      mensaje => this.mensaje = mensaje);
  }

}
