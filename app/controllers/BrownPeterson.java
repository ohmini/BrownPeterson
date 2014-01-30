package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;
import models.User;
import models.brownPeterson.Answer;
import java.util.List;
import models.brownPeterson.Trial;
import models.brownPeterson.Quiz;
import models.brownPeterson.Question;


public class BrownPeterson extends Controller {
    
        public static Result report(){
            User user = User.find.where().eq("username", "s550").findUnique();
            Trial trial = Trial.find.all().get(0);
            int score = 2;
            List<Quiz> quizzes = Quiz.findInvolving(trial);
            List<Question> questions = Question.findInvolving(quizzes);
            List<Answer> answers = Answer.findInvolving(user, quizzes);

            double totalUsedTime = Answer.calculateTotalUsedTime(answers);
            return ok(brownPetersonReport.render(score,totalUsedTime,quizzes.size(), "Report"));
        }

}
