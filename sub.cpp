#include<iostream>
using std::string;
using namespace std;
int main(){
	
	char ch;
	string word;



	char alph2[26][2]={{'a','x'},{'b','n'},{'c','y'},{'d','a'},{'e','h'},{'f','p'},{'g','o'},{'h','g'},{'i','z'},{'j','q'},{'k','w'},{'l','b'},{'m','t'},{'n','s'},{'o','f'},{'p','l'},{'q','r'},{'r','c'},{'s','v'},{'t','m'},{'u','u'},{'v','e'},{'w','k'},{'x','j'},{'y','d'},{'z','i'}};

		cout<<"input text only: ";
		getline(cin, word);


			
			cout<<"if you want Encrypt press E & if you want Decrypt press D : ";
			cin>>ch;
			int j;
			if (ch == 'e' || ch== 'E'){
	
				for(int i=0;i<word.length();i++)
				{

					int k =(int)word[i] - 97;	
					word[i]=alph2[k][1];
					
				}
				cout<<word<<endl;
			}
			else if (ch == 'd' || ch== 'D')
			{
				

		
				for(int i=0;i<word.length();i++)
				{
					for(int j=0; j<26;j++)
					{
						if(word[i]==alph2[j][1])
						{
							cout<<alph2[j][0];

	
							
						}
					}
				}

				
			}
			else
			cout<<"wrong input"<<endl;
			
			cout<<endl;

	system("pause");
	return 0;
}
