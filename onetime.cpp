#include<iostream>
using std::string;
using namespace std;
int main(){
	
	char ch;
	string word;
	string key1;

	char alph[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
		cout<<"input text only: ";
		getline(cin, word);
		cout<<"input key : ";
		getline(cin, key1);
		
		if(key1.length()==word.length())
		{
		
			int * key;
			key = new int [key1.length()];
			
			cout<<"if you want Encrypt press E & if you want Decrypt press D : ";
			cin>>ch;
			int j;
			if (ch == 'e' || ch== 'E'){
				
				for(int i =0;i<key1.length();i++)
				{
					key[i]=(int)key1[i] - 97;
				}
		
				for(int i=0;i<word.length();i++)
				{
						j=(((int)word[i] - 97) + key[i]) % 26;
						
						word[i]=alph[j];
					
				}
				cout<<word<<endl;
			}
			else if (ch == 'd' || ch== 'D')
			{
				
				for(int i =0;i<key1.length();i++)
				{
					key[i]=(int)key1[i] - 97;
				}
		
				for(int i=0;i<word.length();i++)
				{
						j=(((int)word[i] - 97) + 26 - key[i]) % 26;
						
						word[i]=alph[j];
					
				}
				cout<<word<<endl;
				
			}
			else
			cout<<"wrong input"<<endl;
		}
		else
		cout<<"key letter must equal text letter"<<endl;
	system("pause");
	return 0;
}
