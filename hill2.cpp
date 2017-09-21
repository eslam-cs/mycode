#include<iostream>
using std::string;
using namespace std;
int main(){
	
	char ch;
	string word;
	string word2;
	int key[2][2];
	char alph[26]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
		cout<<"input text only: ";
		getline(cin, word);
		cout<<"input matrix key 2*2 from 1 to 25: "<<endl;
		for(int i=0;i<2;i++)
		{	
			for(int k=0;k<2;k++)
			{	
				cout<<"input key number "<<i<<k<<": ";
				cin>>key[i][k];
			}
		}

		cout<<"if you want Encrypt press E & if you want Decrypt press D : ";
		cin>>ch;
		int j=0;

		if (ch == 'e' || ch== 'E'){
	
			for(int i=0;i<word.length();i=i+2)
			{
				for(int k=0;k<2;k++)
				{
					for(int m=0;m<2;m++)
					{	
						j =  j+ (((int)word[i+m] - 97) * key[m][k]);
					}
						j=j%26;
						word2=word2 + alph[j];
						j=0;
				}
			
			}
			cout<<word2<<endl;
	
		}
		else if (ch == 'd' || ch== 'D')
		{
			int f;
			f=key[0][0];
			key[0][0]=key[1][1];
			key[1][1]=f;
			
			key[0][1]=key[0][1]*(-1) + 26;
			key[1][0]=key[1][0]*(-1) + 26;
			for(int i=0;i<word.length();i=i+2)
			{
				for(int k=0;k<2;k++)
				{
					for(int m=0;m<2;m++)
					{	
					
				
						j =  j+ (((int)word[i+m] - 97) * key[m][k]);

					}
						j=j%26;
						word2=word2 + alph[j];
						j=0;
				}
			
			}
			cout<<word2<<endl;
		}
		else
		cout<<"wrong input"<<endl;

	system("pause");
	return 0;
}
