import { Component, input} from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpService } from '../http.service';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [RouterModule, CommonModule, ReactiveFormsModule],
  templateUrl: 'details1.html',
  styleUrl: './details1.component.css'
})
export class Details1Component {
  isGenerated: boolean = false;
  lab1input = new FormGroup({
      p: new FormControl(''),
      q: new FormControl(''),
      x: new FormControl('')
  })

  sequence: String = "";
  sequenceHeader: String = "";
  statisticTest: boolean = false;
  sequenceTest: boolean = false;
  longSequenceTest: boolean = false;
  pokerTest: boolean = false;
  sumOfOnes: string = "";
  zeroSequences: Array<string> = new Array;
  oneSequences: Array<string> = new Array;
  maxSeqLen: string = ""
  combinationCounts: Array<string> = new Array;
  changeContent(sequence: String, length: number, statisticTest: boolean, sequenceTest: boolean, longSequenceTest: boolean, pokerTest: boolean, sumOfOnes: string, zeroSequences: Array<string>, oneSequences: Array<string>, maxSeqLen: string, combinationCounts: Array<string>):void {
    this.sequence = sequence;
    this.statisticTest
    this.sequenceHeader = "Sekwencja (liczba bitów: "+length+")"
    this.statisticTest = statisticTest;
    this.sequenceTest = sequenceTest;
    this.longSequenceTest = longSequenceTest;
    this.pokerTest = pokerTest;
    this.sumOfOnes = sumOfOnes;
    this.zeroSequences = zeroSequences;
    this.oneSequences = oneSequences;
    this.maxSeqLen = maxSeqLen;
    this.combinationCounts = combinationCounts;
  }

  
  randomClicked = false;
  
  constructor(private http: HttpService){}  
  randomValue(): number {
    return Math.floor(Math.random() * (9999 - 1000) + 1000);
  }
  onClick(): void {
    this.randomClicked=false;
  }
  onClickRandom(): void {
    this.randomClicked = true;
  }
  onSubmit(): void {
    if(this.randomClicked) {
      length = 20000
      const pValue: number = this.randomValue();
      const qValue: number = this.randomValue();
      const xValue: number = this.randomValue();
      this.http.getLab1(pValue,qValue,xValue,length).subscribe((resp)=>this.changeContent(resp.sequence, length, resp.statisticTest, resp.sequenceTest, resp.longSequenceTest, resp.pokerTest, resp.sumOfOnes, resp.zeroSequences, resp.oneSequences, resp.maxSeqLen, resp.combinationCounts));
      this.isGenerated=true;
    }
    else {
      length = 20000
      const pValue: number = Number(this.lab1input.controls['p'].value);
      const qValue: number = Number(this.lab1input.controls['q'].value);
      const xValue: number = Number(this.lab1input.controls['x'].value);
      if (pValue==0) {
        this.lab1input.controls["p"].setValue("0");
      }
      if (qValue==0) {
        this.lab1input.controls["q"].setValue("0");
      }
      if (xValue==0) {
        this.lab1input.controls["x"].setValue("0");
      }
      if(Number.isInteger(pValue) && Number.isInteger(qValue) && Number.isInteger(xValue)){
        this.http.getLab1(pValue,qValue,xValue,length).subscribe((resp)=>this.changeContent(resp.sequence, length, resp.statisticTest, resp.sequenceTest, resp.longSequenceTest, resp.pokerTest, resp.sumOfOnes, resp.zeroSequences, resp.oneSequences, resp.maxSeqLen, resp.combinationCounts));
        this.isGenerated=true;
      }
    }
  }
}
