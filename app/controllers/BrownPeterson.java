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


public class BrownPeterson extends Controller {
    
        public static Result report(){
            User user = User.find.where().eq("username", "s550").findUnique();
            Trial trial = Trial.find.all().get(0);
            List<Quiz> quizzes = Quiz.findInvolving(trial);
            List<Answer> answers = Answer.find.where().eq("user_username", user.username).findList();
            return ok(brownPetersonReport.render(user,answers, "Report"));
        }

}
