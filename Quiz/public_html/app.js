/* global questions */

function populate(){
    if(quiz.isEnded()){
        showScores();
    }
    else
    {
        //show question
        var element = document.getElementById("questions");
        element.innerHTML = quiz.getQuestionIndex().text;
    }
}

var questions =[
    new Questions("what is my name ?",{"Rahul","Das","Das Rahul","Rahul Das"} "Rahul Das" );
    
];

var quiz = new Quiz(questions);

populate();