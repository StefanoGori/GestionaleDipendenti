import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { LoginComponent } from './features/login/login.component';
import { NavbarComponent } from './features/navbar/navbar.component';
import { SharedModule } from './shared/shared.module';
import { DipendenteComponent } from './features/dipendente/dipendente.component';
import { HolidaysComponent } from './features/holidays/holidays.component';
import { PermitsComponent } from './features/permits/permits.component';
import { AdminComponent } from './features/admin/admin.component';
import { ModalNewUserComponent } from './features/modal-new-user/modal-new-user.component';
import { DeleteDipendenteComponent } from './features/delete-dipendente/delete-dipendente.component';
import { ScheduleModalComponent } from './features/schedule-modal/schedule-modal.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    DipendenteComponent,
    HolidaysComponent,
    PermitsComponent,
    AdminComponent,
    ModalNewUserComponent,
    DeleteDipendenteComponent,
    ScheduleModalComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule, 
    ReactiveFormsModule,
      ],
  exports: [
    SharedModule,
    ReactiveFormsModule,

  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    provideHttpClient(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
