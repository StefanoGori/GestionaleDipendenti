import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { LoginComponent } from './features/login/login.component';
import { NavbarComponent } from './features/navbar/navbar.component';
import { SharedModule } from './shared/shared.module';
import { TabellaorariComponent } from './features/dipendente/tabellaorari/tabellaorari.component';
import { DipendenteComponent } from './features/dipendente/dipendente.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    TabellaorariComponent,
    DipendenteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule

  ],
  exports: [
    SharedModule

  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
