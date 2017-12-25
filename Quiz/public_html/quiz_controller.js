function Quiz(questions){
    this.scores = 0;
    this.questions = questions;
    this.questionsIndex = 0;
}
Quiz.prototype.getQuestionIndex = function()
{
    return this.questions[this.questionsIndex];
};
Quiz.prototype.isEnded = function()
{
    return this.questions.lenght === this.questionsIndex;
};
Quiz.prototype.guess = function(answer)
{
    this.questionsIndex;
    
    if(this.questionsIndex().correctAnswer(answer))
    {
        this.scores++;
    }
};
