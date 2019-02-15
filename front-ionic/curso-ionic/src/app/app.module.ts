import { Utils } from './../entity/Utils';
import { Http, HttpModule } from '@angular/http';
import { LoginPageModule } from './../pages/login/login.module';
import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { ComponentInicial } from './app.component';

import { AboutPage } from '../pages/about/about';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';
import { PerfilPage } from './../pages/perfil/perfil';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { LoginServiceProvider } from '../providers/login-service/login-service';
import { CookieService } from 'angular2-cookie/core';

import { XHRBackend, RequestOptions } from '@angular/http';
import { InterceptorHttpService } from './../providers/InterceptorHttpService';

@NgModule({
  declarations: [
    ComponentInicial,
    AboutPage,
    ContactPage,
    PerfilPage,
    HomePage,
    TabsPage
    
  ],
  imports: [
    BrowserModule,
    HttpModule,
    LoginPageModule,
    IonicModule.forRoot(ComponentInicial)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    ComponentInicial,
    AboutPage,
    PerfilPage,
    ContactPage,
    HomePage,
    TabsPage
    
  ],
  providers: [
    StatusBar,
    CookieService,
    SplashScreen,
    Utils,
    {
      provide: Http,
      useFactory: (backend: XHRBackend, defaultOptions: RequestOptions) => {
        return new InterceptorHttpService(backend, defaultOptions);
      },
      deps: [XHRBackend, RequestOptions]
    }
    ,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    LoginServiceProvider
  ]
})
export class AppModule {}
