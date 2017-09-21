#include<iostream>
using std::string;
using namespace std;
int main(){
	
	char ch;
	string word;
	int key;
	
		cout<<"input text only: ";
		getline(cin, word);
		cout<<"input key from 1 to 26: ";
		cin>>key;
		cout<<"if you want Encrypt press E & if you want Decrypt press D";
		cin>>ch;
	
		if (ch == 'e' || ch== 'E'){
	
			for(int i=0;i<word.length();i++)
			{
				for(int j=1;j<=key;j++)
				{
					if(word[i] == 'z')
					word[i]='a';
					else
					word[i]++;
				
				}
			}
			cout<<word<<endl;
		}
		else if (ch == 'd' || ch== 'D')
		{
			for(int i=0;i<word.length();i++)
			{
				for(int j=1;j<=key;j++)
				{
					if(word[i] == 'a')
					word[i]='z';
					else
					word[i]--;
				
				}
			}
			cout<<word<<endl;
		}
		else
		cout<<"wrong input"<<endl;

	system("pause");
	return 0;
}
