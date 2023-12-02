import { Component, OnInit } from '@angular/core';
import { Proveedor } from 'src/interfaces/proveedor';
import { ProveedorService } from './proveedor.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-proveedor',
  templateUrl: './proveedor.component.html',
  styleUrls: ['./proveedor.component.css']
})
export class ProveedorComponent implements OnInit {

  title: string = 'Bienvenido Candidato 01';
  bienvenido!: boolean;
  proveedores!: Proveedor[];
  formPro!: FormGroup;
  titleForm!: string;
  editar!: boolean;
  nomina: any;

  visible!: boolean;
  constructor(private proveedorService: ProveedorService,
    private messageService: MessageService,
    private fb: FormBuilder,) {
    this.bienvenido = true;
  }

  ngOnInit(): void {
    this.getProveedores();
    this.initForm();
  }

  initForm() {
    this.formPro = this.fb.group({
      'idProveedor': new FormControl(''),
      'nombre': new FormControl('', [Validators.required]),
      'apellidos': new FormControl('', [Validators.required]),
      'razonSocial': new FormControl('', Validators.required),
      'direccion': new FormControl('', Validators.required),
      'nomina': new FormControl(this.nomina, Validators.required),
      'estatus': new FormControl(true)
    }
    );
  }

  async getProveedores() {
    this.proveedores = await this.proveedorService.getProveedores().toPromise() || [];
  }

  continuar() {
    this.bienvenido = false;
  }

  openModal(title: string, proveedor: any) {
    this.visible = true;
    this.titleForm = title;
    if (proveedor !== null) {
      this.editar = true;
      this.setValues(proveedor);
    } else {
      this.initForm();
      this.editar = false;
    }
  }

  setValues(p: Proveedor) {
    this.formPro.get(['idProveedor'])?.setValue(p.idProveedor);
    this.formPro.get(['nombre'])?.setValue(p.nombre);
    this.formPro.get(['apellidos'])?.setValue(p.apellidos);
    this.formPro.get(['razonSocial'])?.setValue(p.razonSocial);
    this.formPro.get(['direccion'])?.setValue(p.direccion);
    this.formPro.get(['nomina'])?.setValue(p.nomina);
    this.formPro.get(['estatus'])?.setValue(p.estatus);
  }

  guardar() {
    this.proveedorService.saveProveedor(this.formPro.value).toPromise().then(
      response => {
        console.log(response);
        this.getProveedores();
        this.visible = false;
        this.messageService.add({ severity: 'success', summary: 'Éxito', detail: 'Operación Exitosa' });
      }
    );
  }


  eliminar(idProveedor: number) {
    this.proveedorService.deleteProveedor(idProveedor).toPromise().then(
      (response) => {
        this.getProveedores();
        this.messageService.add({ severity: 'success', summary: 'Éxito', detail: 'Proveedor eliminado' });
      }
    );
  }
}
