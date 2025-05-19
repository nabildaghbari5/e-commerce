import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CommandesRoutingModule } from './commandes-routing.module';
import { CommandeClientComponent } from './commande-client/commande-client.component';
import { CommandeAdminComponent } from './commande-admin/commande-admin.component';


@NgModule({
  declarations: [
    CommandeClientComponent,
    CommandeAdminComponent
  ],
  imports: [
    CommonModule,
    CommandesRoutingModule
  ]
})
export class CommandesModule { }
