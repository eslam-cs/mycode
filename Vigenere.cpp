#include<iostream>
using std::string;
using namespace std;
int main(){
	
	char ch;
	string word;
	int key[6];
	char alph[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
		cout<<"input text only: ";
		getline(cin, word);
		cout<<"input 5 key from 1 to 25: "<<endl;
		for(int i=0;i<6;i++)
		{	
			cout<<"input key number "<<i+1<<": ";
			cin>>key[i];
		}

		cout<<"if you want Encrypt press E & if you want Decrypt press D : ";
		cin>>ch;
		int j;
		if (ch == 'e' || ch== 'E'){
	
			for(int i=0;i<word.length();i++)
			{
					j=(((int)word[i] - 97) + key[i%6]) % 26;
					
					word[i]=alph[j];
				
			}
			cout<<word<<endl;
		}
		else if (ch == 'd' || ch== 'D')
		{
			for(int i=0;i<word.length();i++)
			{

					j=(((int)word[i] - 97) + 26 - key[i%6] ) % 26;
					
					word[i]=alph[j];
			}
			cout<<word<<endl;
		}
		else
		cout<<"wrong input"<<endl;

	system("pause");
	return 0;
}
