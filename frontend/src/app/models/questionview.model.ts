import { Question } from './question.model';

export interface QuestionView {
  question: Question;
  showAnswer: boolean;
}
