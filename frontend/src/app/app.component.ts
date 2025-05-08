import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Question } from './question.model';
import { QuestionService } from './question.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  questions: Question[] = [];

  constructor(private questionService: QuestionService) {}

  ngOnInit(): void {
    this.questionService.getQuestions().subscribe((data) => {
      this.questions = data;
    });
  }
}
