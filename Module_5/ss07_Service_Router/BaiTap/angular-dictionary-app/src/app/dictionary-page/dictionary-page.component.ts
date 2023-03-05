import { Component, OnInit } from '@angular/core';
import {IWord} from "../model/iword";
import {DictionaryService} from "../service/dictionary.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {

  wordList: IWord[] = [];

  constructor(private dictionaryService: DictionaryService, private router: Router) { }

  ngOnInit(): void {
    this.wordList = this.dictionaryService.getAllWord();
  }

  translate(wordSearch: string) {
    this.router.navigateByUrl('dictionary-detail/' + wordSearch);
  }
}
