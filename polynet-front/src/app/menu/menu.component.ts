import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth/auth.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  constructor(private authService:AuthService) { }

  isConnected(){

    return  this.authService.isConnected();
  };

  ngOnInit() {
  }


  logout() {
    this.authService.logout();
  }
}
