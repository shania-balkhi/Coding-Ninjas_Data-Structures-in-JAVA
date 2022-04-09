/*
Code: Search word in Trie

Implement the function SearchWord for the Trie class.
For a Trie, write the function for searching a word. Return true if the word is found successfully, otherwise return false.
Note : main function is given for your reference which we are using internally to test the code.
*/

class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

    /*--------------------------------------------------------code (for search() )------------------------------------------------------*/
    public boolean search(String word){
		return searchHelper(root, word);
	}
    
    boolean ans;
    private boolean searchHelper(TrieNode root, String word){
        // base case
        if (word.length() == 0) {
            return root.isTerminating; 
            /* or
            if(root.isTerminating == true){
            	return true;
            }else{ //i.e., root.isTerminating == false
            	return false;
            }
            */
        }

        // induction hypothesis
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }

        // induction step
        return searchHelper(child, word.substring(1));
    }
    
    /*-----------------------------x-----------------------------code (for search() )-----------------------x---------------------------*/


	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));

	}

	public void add(String word){
		add(root, word);
	}
}




/*----------------------------------------------------------algo (for search() )----------------------------------------------------------------*/
/*
algo - (for searchHelper method)
 1. it's a recursive implementation
 
 2. base case : as word length becomes zero, return true or false depending on whether the 'isTermating' field of the lastLetterOfTheWord
                is true or false i.e.,
                if isTerminating == true, return true 
                or
                if isTerminating == false, return false
                
 3. induction hypothesis :
 
 	3.1 find the index of the first letter of the word to be inserted, say
 	'childIndex' using the formula : word.charAt(0) - 'A' (line 53)
 	for eg. if word is 'NOTE', we'll find index of 'N' by : 'N' - 'A' = required
 	index of 'N'.
 	eg no. 2, if word is 'B', then it will be : 'B' - 'A' = 68 - 67 = 1 which is
 	the required index for letter 'B'.
 
 	3.2 store the element corresponding to the ChildIndex in a TrieNode variable,
 	say, 'child' (line 54)
 
 	3.3 if the child is not present, straight-away return false (because this indicates that the word doesn't even exist!)
 
 	3.4 if the child is present, go to step 4
 
 4. induction step :
 
 	call searchHelper method, pass (root, word.substring(1)) as arguments. (line 60) and return this function call
 */ 
/*-----------------------------------------------------------algo (for search() )----------------------------------------------------------------*/




/*------------------------------------------------------------algo (for add() )-------------------------------------------------------------*/
/*
 algo - (for addHelper method)
 1. it's a recursive implementation
 
 2. base case : as word length becomes zero, make isTerminal = true and return (lines 67 to 70)
  
 3. induction hypothesis :
 
 	3.1 find the index of the first letter of the word to be inserted, say
 	'childIndex' using the formula : word.charAt(0) - 'A' (line 71)
 	for eg. if word is 'NOTE', we'll find index of 'N' by : 'N' - 'A' = required
 	index of 'N'.
 	eg no. 2, if word is 'B', then it will be : 'B' - 'A' = 68 - 67 = 1 which is
 	the required index for letter 'B'.
 
 	3.2 store the element corresponding to the ChildIndex in a TrieNode variable,
 	say, 'child' (line 72)
 
 	3.3 if the child is present, go to step 4
 
 	3.4 if the child is not present, create a 'child' (say) TrieNode; and store
 	this 'child' element in the 'children' (say) ArrayList of root at the
 	childIndex so calculated (line 73 to 77)
 
 4. induction step :
 
 	call addhelper method and pass (root, word.substring(1)) as arguments. (line 78)
 */
/*--------------------------------------------------------------algo (for add() )-------------------------------------------------------------*/
