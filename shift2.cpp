#include<iostream>
using std::string;
using namespace std;
int main(){
	
	char ch;
	string word;
	int key;
	char alph[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
		cout<<"input text only: ";
		getline(cin, word);
		cout<<"input key from 1 to 26: ";
		cin>>key;
		cout<<"if you want Encrypt press E & if you want Decrypt press D : ";
		cin>>ch;
		int j;
		if (ch == 'e' || ch== 'E'){
	
			for(int i=0;i<word.length();i++)
			{
					j=(((int)word[i] - 97) + key) % 26;
					
					word[i]=alph[j];
				
			}
			cout<<word<<endl;
		}
		else if (ch == 'd' || ch== 'D')
		{
			for(int i=0;i<word.length();i++)
			{
					j=(((int)word[i] - 97) - key + 26) % 26;
					
					word[i]=alph[j];
			}
			cout<<word<<endl;
		}
		else
		cout<<"wrong input"<<endl;

	system("pause");
	return 0;
}
