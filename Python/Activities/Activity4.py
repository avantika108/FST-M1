username1= input("Enter username1")
username2=input("Enter username2")
while True:
    user1_answer= input(username1+ ", do you want to choose rock paper scissors?" ).lower()

    user2_answer=input(username2+ "do you want to choose rock paper scissors?").lower()

    if user1_answer==user2_answer :
                print("Its a tie!!!")
    elif  user1_answer=='rock':
                if user2_answer =='scissors' :
                     print("Rock wins:")
                else: 
                     print("Paper wins!!")    

    elif  user1_answer=='scissors':
                if user2_answer=='paper':
                    print ('Scissor wins')
                else :
                    print('Rock wins')    
    elif user1_answer == 'paper':
                if user2_answer == 'rock':
                    print("Paper wins!")
                else:
                    print("Scissors win!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")
 
   
    
        
    # Ask them if they want to play again
    repeat = input("Do you want to play another round? Yes/No: ").lower()
    
    # If they say yes, don't do anything
    if(repeat == "yes"):
        pass
    # If they say no, exit the game
    elif(repeat == "no"):
        raise SystemExit
    # If they say anything else, exit with an error message.
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit