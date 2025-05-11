import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Question } from './models/question.model';
import { QuestionView } from './models/questionview.model';
import { QuestionService } from './services/question.service';
import { NavbarComponent } from './navbar/navbar.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  questions: QuestionView[] = [];
  lessonsNb: number = 0;

  constructor(private questionService: QuestionService) {}

  ngOnInit(): void {
    this.questionService.getQuestions().subscribe((data) => {
      this.questions = data.map((q) => ({ question: q, showAnswer: false }));
    });
    this.questionService.getLessons().subscribe((data) => {
      this.lessonsNb = data;
    });
  }

  toggleAnswer(qv: QuestionView): void {
    qv.showAnswer = !qv.showAnswer;
  }
}
