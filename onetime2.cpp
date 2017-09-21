#include<iostream>
#include <stdlib.h>
using std::string;
using namespace std;
int main(){
	
	char ch;
	string word;
	string key1;

	char alph[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
		cout<<"input text only: ";
		getline(cin, word);



			int k;

			k=0+(rand()%(int)(26));
			cout<<"if you want Encrypt press E & if you want Decrypt press D : ";
			cin>>ch;
			int j;
			if (ch == 'e' || ch== 'E'){
				
				
		
				for(int i=0;i<word.length();i++)
				{
						k=0+(rand()%(int)(26));
						cout<<k<<endl;
						j=(((int)word[i] - 97) + k) % 26;
						
						word[i]=alph[j];
					
				}
				cout<<word<<endl;
			}

			else
			cout<<"wrong input"<<endl;

	system("pause");
	return 0;
}
