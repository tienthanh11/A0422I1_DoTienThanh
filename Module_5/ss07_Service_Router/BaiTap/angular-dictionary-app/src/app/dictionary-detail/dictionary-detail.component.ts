import {Component, OnInit} from '@angular/core';
import {IWord} from "../model/iword";
import {DictionaryService} from "../service/dictionary.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  word: IWord = {};

  constructor(private dictionaryService: DictionaryService, private activeRouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activeRouter.paramMap.subscribe((param) => {
      const id = (param.get('word'));
      this.word = this.dictionaryService.translate(id);
    });
  }
}
