firstName = "harish"
lastName = "velmurugan"
# print(f"{firstName} {lastName}".title())
# print(0.2 + 0.1)
x,y,z = 1,2,3
# This is just a comment
# print(f"All the marks are {x + y + z}")
printElements = ["harish velmurugan", "Siva", "Praveen", "Siva"]
# print(printElements[-2].title())
badBoy = "Siva"
printElements.remove(badBoy)
# print(printElements)

magicians = ['alice', 'david', 'carolina']
# for magician in magicians:
    #  print(f"{magician.title()}, that was a great trick!") 
    #  print(f"I can't wait to see your next trick, {magician.title()}.\n")


threeNumbers = list(range(3,31,3))
# print(threeNumbers)
squares = []
for number in threeNumbers:
    squares.append(number ** 2)

# print( squares)

tupleList = (1,2,3)
normalList = [1,2,3]
# print(normalList)
copyList = normalList[:]
normalList[1] = 4
normalList.insert(0, 5)
normalList.append(6)
# print(normalList[:])
# print(copyList[:])


namesAndFavoriteSuperstar = {
    'harish' : 'randy ortan',
    'binu rakhul' : 'the rock',
    'vignesh' : 'finn balor'
}

# for name in namesAndFavoriteSuperstar.keys():
#     print(f"The favorite superstar of {name.title()} is {namesAndFavoriteSuperstar[name].upper()}")

favorite_languages = {
       'jen': 'python',
       'sarah': 'c',
       'edward': 'ruby',
       'phil': 'python',
       }

def process():
    return int(input("Do you want to continue ? \n\t 1. Yes \n\t 2. No \n"))

nameOfTheUser = input("Tell me your name : \n")
# print(f"{message}! What are you doing?" )

continueProcess = 1
while continueProcess != 2 : 
    print("----------------------------------------------------------------")
    numberProvided = int(input("Enter a number which you want to check? \n"))
    if numberProvided % 10 == 0:
        print(f"Hi {nameOfTheUser} !, {numberProvided} is a multiple of 10")
    else:
        print(f"Hi {nameOfTheUser} !, {numberProvided} is not a multiple of 10")
    print("----------------------------------------------------------------")
    continueProcess = process()


