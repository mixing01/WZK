import { Component} from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpService } from '../http.service';
import { CommonModule } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [RouterModule, CommonModule, ReactiveFormsModule],
  templateUrl: 'details1.html',
  styleUrl: './details1.component.css'
})
export class Details1Component {
  isGenerated: boolean = false;
  changeContent(sequence: String, length: number):void {
    this.sequence = sequence;
    this.sequenceHeader = "Sekwencja (liczba bitów: "+length+")"
  }
  sequence: String = "";
  sequenceHeader: String = "";
  constructor(private http: HttpService){}
  onClick(): void {
    length = 20000
    this.http.getLab1(1425,3624,1242,length).subscribe((resp)=>this.changeContent(resp.sequence, length));
    this.isGenerated=true;
  }
  
}
