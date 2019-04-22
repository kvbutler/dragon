import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'spa-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  public appName = 'App';

  constructor(public authService: AuthService) { }

  ngOnInit() {
    this.appName = environment.appName;
  }

}
