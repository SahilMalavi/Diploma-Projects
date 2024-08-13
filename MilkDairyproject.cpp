#include <iostream>
#include <windows.h>
#include <time.h>
using namespace std;

void login();
void deposite_milk();
void menu();
void meal();
void loan();
void about();

class info
{
public:
    char name[50];
    int no, fat;
    float milk;
    char day[10];

public:
    void getdata()
    {
        cout << "\nEnter Your Name(without space): ";
        cin >> name;
        cout << "\nEnter Your No. : ";
        cin >> no;
        cout << "\nEnter Morning OR Evening : ";
        cin >> day;
        cout << "\nEnter Milk in litre: ";
        cin >> milk;
        cout << "\nEnter Milk fat: ";
        cin >> fat;
    }
    void putdata();
};
void info ::putdata()
{
    float fat_rate = 6.43, total;
    float fat_t = (fat * fat_rate);
    total = (fat * fat_rate) * milk;
    system("cls");
    cout << "\n\tYOUR BILL-";
    cout << "\n\t\t  ====================================";
    cout << "\n\t\t|          Nirmal milk dairy           |" << endl;
    cout << "\n\t\t  Name : " << name << "       No. - " << no << endl;
    cout << "\n\t\t  Milk session: " << day << endl;
    cout << "\n\t\t  Milk : " << milk << " Litre"
         << "      Fat: " << fat << endl;
    cout << "\n\t\t| Fat rate: " << fat_t << "     Total: " << total << "rs  |";
    cout << "\n\t\t  ====================================" << endl;
}

char user[50];
int pass;
int i, opt;

int main()
{
    login();
    menu();
}
// login function,for entering into Milk dairy system
void login()
{

    cout << "\n\n\t\t\t|--------------LOGIN----------------|" << endl;
    cout << "\n\t\t\t Enter User_name(without space): ";
    cin >> user;
    cout << "\n\t\t\t Enter Password: ";
    cin >> pass;
    cout << "\n\t\t\t|-----------------------------------|" << endl;
    if (pass == 4914)
    {
        system("cls");
        cout << "\n\tsuccessfully logging";
        for (int i = 0; i < 10; i++)
        {
            cout << ".";
            Sleep(250);
        }
        Beep(523, 900);
    }
    else
    {
        cout << "\nERROR.....! PLEASE CHECK YOUR PASSWORD.";
        main();
    }
}
// deposite_milk function, for deposite todays milk and generating bill
void deposite_milk()
{
    info n;
    int animal;
    char back;

    cout << "\n\n__________________________________________\n";
    cout << "\n**Enter your Milk animal NO. from below**";
    cout << "\n\n\t|1. BUFFALO |2. COW |\n";
    cin >> animal;

    if (animal == 1)
        cout << "\nYou choose 'BUFFALO' \n";
    else if (animal != 1 && animal != 2)
    {
        cout << "\nError! choose only option [1/2] ....." << endl;
        Sleep(2500);
        system("cls");
        deposite_milk();
    }

    else
        cout << "\nYou choose 'COW' \n";

    n.getdata();
    // cout << "\n\n__________________________________________";
    n.putdata();
    cout << "\nWant to go back to the Menu [y/n]-";
    cin >> back;

    if (back == 'y' || back == 'Y')
    {
        menu();
    }
    else
    {
        deposite_milk();
    }
}
// function for main menu
void menu()
{
    system("cls");
    cout << "\n\n\t\t\twww.expertskeys.com";
    cout << "\n\n\t\t******welcome in nirmal milk dairy [ " << user << " ]******";
    time_t my_time = time(NULL);

    cout << "\t    DATE: " << ctime(&my_time);
    cout << "\n\n1.Milk";
    cout << "\n2.Animal MEAL";
    cout << "\n3.Apply loan";
    cout << "\n4.About our Dairy";
    cout << "\n5.Logout";

    cout << "\n\nEnter option: ";
    cin >> opt;

    switch (opt)
    {
    case 1:
        deposite_milk();
        break;

    case 2:
        meal();
        break;

    case 3:
        loan();
        break;

    case 4:
        about();
        break;
    case 5:
        cout << "\n\t\t\tThank you | keep visiting";
        exit(0);
    default:
        break;
    }
}

// function for get animal food/meal
void meal()
{
    system("cls");
    long int prod, how;
    char go;
    long int totalval;
    cout << "\n\t\t\t-- OUR ANIMAL MEAL PRODUCTS --";
    cout << "\n\t\t ============================================";
    cout << "\n\t\t| 1.Mahalakshmi Animal MEAL        - 1100rs  |";
    cout << "\n\t\t| 2.Mahalakshmi Bhusa              - 1000rs  |";
    cout << "\n\t\t| 3.For growth in Milk-Products    - 350rs   |";
    cout << "\n\t\t ============================================";

    cout << "\n\n\t*Enter Any Above Option for buying Products: ";
    cin >> prod;

    switch (prod)
    {
    case 1:
        cout << "\n\n\tYou choose - Mahalakshmi Animal MEAL";
        cout << "\n\n\tEnter how many meal you want :- ";
        cin >> how;

        totalval = 1100 * how;

        cout << "\n\tYour Bill-";
        cout << "\n\t\t _________________________________________";
        cout << "\n\t\t|           NIRMAL MILK DAIRY                |";
        cout << "\n\n\t\t  Product name                Quantity   ";
        cout << "\n\n\t\t  *Mahalakshmi Animal MEAL       " << how;
        cout << "\n\n\t\t          Total Bill-" << totalval << "rs";
        cout << "\n\t\t|_________________________________________|";
        break;

    case 2:
        cout << "\nYou choose - Mahalakshmi Bhusa ";
        cout << "\n\nEnter how many meal you want :- ";
        cin >> how;

        totalval = 1000 * how;

        cout << "\n\tYour Bill-";
        cout << "\n\t\t _________________________________________";
        cout << "\n\t\t|           NIRMAL MILK DAIRY             |";
        cout << "\n\n\t\t  Product name                 Quantity   ";
        cout << "\n\n\t\t  *Mahalakshmi Animal Bhusa       " << how;
        cout << "\n\n\t\t          Total Bill-" << totalval << "rs";
        cout << "\n\t\t|_________________________________________|";
        break;

    case 3:
        cout << "\nYou choose - Milk growth products ";
        cout << "\n\nEnter how many meal you want :- ";
        cin >> how;

        totalval = 350 * how;

        cout << "\n\tYour Bill-";
        cout << "\n\t\t _________________________________________";
        cout << "\n\t\t|          NIRMAL MILK DAIRY              |";
        cout << "\n\n\t\t   Product name                Quantity   ";
        cout << "\n\n\t\t  *growth in Milk-Product        " << how;
        cout << "\n\n\t\t          Total Bill-" << totalval << "rs";
        cout << "\n\t\t|_________________________________________|";
        break;

    default:
        cout << "\n\t\tPlz Enter option between 1 to 3";
        Sleep(1000);
        meal();
        break;
    }
    cout << "\n\nWant to go back to the main menu [y/n] : ";
    cin >> go;

    if (go == 'y' || go == 'Y')
        menu();
    else
        meal();
}

// function for get loan
void loan()
{
    int loanopt;
    long long int principal, tenure, emi;
    long long int interest, totaldue;
    char goback;
    system("cls");
    cout << "\n\t\t ----*loan*-----------*rate*----";
    cout << "\n\t\t| 1.Home loan          12%      |";
    cout << "\n\t\t| 2.Car loan           10%      |";
    cout << "\n\t\t| 3.Agriculture loan    7%      |";
    cout << "\n\t\t -------------------------------";

    cout << "\n\tEnter which loan option you choose: ";
    cin >> loanopt;

    switch (loanopt)
    {
    case 1:

        cout << "\n\nYou Choose- Home loan";
        cout << "\n\nEnter loan amount: ";
        cin >> principal;
        if (principal > 1000000)
        {
            cout << "\n\t\tError!..Maximum amount of loan is 10,00,000 rs";
            Sleep(2600);
            loan();
        }
        cout << "\nEnter tenure(in years): ";
        cin >> tenure;

        interest = (principal * 12 * tenure) / 100;
        totaldue = principal + interest;
        emi = totaldue / (tenure * 12);

        cout << "\n\tYour Loan receipt-";
        cout << "\n\t\t _________________________________________";
        cout << "\n\t\t|         --NIRMAL MILK DAIRY--           |";
        cout << "\n\n\t\t   Home loan[on 12%]  -" << principal << "rs";
        cout << "\n\n\t\t   Interest           -" << interest << "rs";
        cout << "\n\n\t\t   Total loan due     -" << totaldue << "rs";
        cout << "\n\n\t\t          YOUR EMI -" << emi << "rs";
        cout << "\n\t\t|_________________________________________|";

        break;

    case 2:
        cout << "\n\nYou Choose- Car loan";
        cout << "\n\nEnter loan amount: ";
        cin >> principal;
        if (principal > 1000000)
        {
            cout << "\nMaximum amount of loan is 10,00,000 rs";
            Sleep(2600);
            loan();
        }
        cout << "\nEnter tenure(in years): ";
        cin >> tenure;

        interest = (principal * 10 * tenure) / 100;
        totaldue = principal + interest;
        emi = totaldue / (tenure * 10);

        cout << "\n\tYour Loan receipt-";
        cout << "\n\t\t _________________________________________";
        cout << "\n\t\t|         --NIRMAL MILK DAIRY--           |";
        cout << "\n\n\t\t   Car loan[on 10%]   -" << principal << "rs";
        cout << "\n\n\t\t   Interest           -" << interest << "rs";
        cout << "\n\n\t\t   Total loan due     -" << totaldue << "rs";
        cout << "\n\n\t\t         YOUR EMI   -" << emi << "rs";
        cout << "\n\t\t|_________________________________________|";

        break;

    case 3:
        cout << "\n\nYou Choose- Agriculture loan";
        cout << "\n\nEnter loan amount: ";
        cin >> principal;
        if (principal > 1000000)
        {
            cout << "\nMaximum amount of loan is 10,00,000 rs";
            Sleep(2600);
            loan();
        }
        cout << "\nEnter tenure(in years): ";
        cin >> tenure;

        interest = (principal * 7 * tenure) / 100;
        totaldue = principal + interest;
        emi = totaldue / (tenure * 7);

        cout << "\n\tYour Loan receipt-";
        cout << "\n\t\t _________________________________________";
        cout << "\n\t\t|         --NIRMAL MILK DAIRY--           |";
        cout << "\n\n\t\t Agriculture loan[on 7%] -" << principal << "rs";
        cout << "\n\n\t\t      Interest           -" << interest << "rs";
        cout << "\n\n\t\t      Total loan due     -" << totaldue << "rs";
        cout << "\n\n\t\t           YOUR EMI -" << emi << "rs";
        cout << "\n\t\t|_________________________________________|";

        break;

    default:
        cout << "\nEnter option between 1 to 3";
        Sleep(1000);
        loan();
        break;
    }
    cout << "\n\nWant to go back to the main menu [y/n] : ";
    cin >> goback;

    if (goback == 'y' || goback == 'Y')
        menu();
    else
        loan();
}

void about()
{
    char mn;
    system("cls");
    cout << "\n\n\t\t******Welcome In Nirmal Milk Dairy [ " << user << " ]******";

    cout << "\n\n\n\tEstablishment date:13/11/2021";
    cout << "\n\n\tThank's for visiting our dairy,Nirmal milk dairy was established on\n\t13 November 2021. in our dairy, all new technology devices\n\tare present to make customers easy to deposit their animal milk\n\tand all other work. here you can get lots of benefits in any festival\n\t like Diwali bonus, or Ganesh Chaturthi bonus.\n\n\twe also arrange a trip for our associate 2 times yearly for free.\n\tOur loan rate is also less than others. here you can get up to 10 \n\tlakh loan at a time with less loan rate. we can due different types\n\tof loan like for home, you can get our home loan plan [rate-12%], for\n\t buying vehicle [loan rate-10%] and for agriculture [loan rate 7%]\n\t only. you can also get other benefits, for that make associate\n\t of our milk dairy if you are not yet. ";

    cout << "\n\n\t\t\tThank you | Keep visiting\n\n\t \n\t\t\t POWERED BY EXPERTSKEYS.COM   \n|_______________________________________________________________|\n\n";
    cout << "\nBack to the Menu [y/n]- ";
    cin >> mn;

    if (mn == 'y' || mn == 'Y')
        menu();
    else
        about();
}
