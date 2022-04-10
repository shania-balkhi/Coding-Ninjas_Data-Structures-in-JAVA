//code
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


class Trie {

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

  
  
  
  
  
  

  
  /*--------------------------------------------------------code (for add() )------------------------------------------------------*/
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
/*--------------------------x-----------------------------code (for add() )---------------------------------x--------------------*/









/*--------------------------------------------------------code (for remove() )------------------------------------------------------*/
    public void remove(String word) {
        removeHelper(root, word);
    }

    private void removeHelper(TrieNode root, String word) {
        // base case
        if (word.length() == 0) {
            root.isTerminating = false;
            return;
        }

        // induction hypothesis
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }

        // induction step
        removeHelper(child, word.substring(1));
        // important condition (extended remove function) - asked in interviews (lines
        // 120 to 123) -
        if (!child.isTerminating && child.childCount == 0) {
            root.children[childIndex] = null;
            --root.childCount;
        }

    }

    /*-----------------------------x-----------------------------code (for remove() )-----------------------x---------------------------*/

}

public class TrieUse {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("NODE");
        t.add("AND");

        System.out.println(t.search("AND"));
        t.remove("AND");
        System.out.println(t.search("AND"));
        System.out.println(t.search("AN"));
        t.remove("AN");
        System.out.println(t.search("AN"));

        t.add("NEWS");
        t.add("NEW");
        System.out.println(t.search("NEW"));
        System.out.println(t.search("NEWS"));
        t.remove("NEWS");
        System.out.println(t.search("NEW"));
        System.out.println(t.search("NEWS"));

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
 	'childIndex' using the formula : word.charAt(0) - 'A' (line 46)
 	for eg. if word is 'NOTE', we'll find index of 'N' by : 'N' - 'A' = required
 	index of 'N'.
 	eg no. 2, if word is 'B', then it will be : 'B' - 'A' = 68 - 67 = 1 which is
 	the required index for letter 'B'.
 
 	3.2 store the element corresponding to the ChildIndex in a TrieNode variable,
 	say, 'child' (line 47)
 
 	3.3 if the child is not present, straight-away return false (because this indicates that the word doesn't even exist!)
 
 	3.4 if the child is present, go to step 4
 
 4. induction step :
 
 	call searchHelper method, pass (root, word.substring(1)) as arguments. (line 53) and return this function call
 */ 
/*----------------------------------x------------------------algo (for search() )--------------------------------------x--------------------------*/









/*----------------------------------------------------------algo (for remove() )----------------------------------------------------------------*/
/*
 algo - (for searchHelper method)
 1. it's a recursive implementation
 2. base case : as word length becomes zero, make 'isTerminal' for the
                character concerned as false (since that word has
                to be removed, the last character can no longer exist as a terminalCharacter)
 
 3. induction hypothesis :

    3.1 find the index of the first letter of the word to be removed, say
        'childIndex' using the formula : word.charAt(0) - 'A' (line 110)
        for eg. if word is 'NOTE', we'll find index of 'N' by : 'N' - 'A' = required
        index of 'N'.
        eg no. 2, if word is 'B', then it will be : 'B' - 'A' = 68 - 67 = 1 which is
        the required index for letter 'B'.
 
    3.2 store the element corresponding to the ChildIndex in a TrieNode variable,
        say, 'child' (line 111)
 
    3.3 if the child is not present, simply return (because how can you delete a
        word that doesn't even exist!)
 
    3.4 if the child is present, go to step 4
 
 4. induction step :
 
    call removeHelper method, pass (root, word.substring(1)) as arguments. (line
    117)
 
 5.Important Step!!!!!!!!!!!!!! - is asked in interviews :
   this is an extension of the removeHelper() or in other words, the extended
   removeHelper().
   
   Up untill this step, only the 'isTerminating' field was being manipulated to
   yield the desired output,
   and the actual word (or the space occupied by the word, or the refernce to
   the word) was not removed in actuality; meaning that
   it's reference existed in the 'children' ArrayList of root. Since this should
   not be the case, step 5 is implemented. (lines 120 to 123)
   make the reference of the character concerned as null in the 'children' Array
   List of root i.e., 'root.children[childIndex] = null; if and only if that
   character is non-TerminatingCharacter and it's countOfNumberOfChildren
   ('childCount') is zero.
   (after that decrement the 'childCount' field)
 */
/*----------------------------x------------------------------algo (for remove() )-------------------------------------x--------------------------*/










/*------------------------------------------------------------algo (for add() )-------------------------------------------------------------*/
/*
 algo - (for addHelper method)
 1. it's a recursive implementation
 
 2. base case : as word length becomes zero, make isTerminal = true and return (lines 68 to 71)
  
 3. induction hypothesis :
 
 	3.1 find the index of the first letter of the word to be inserted, say
 	'childIndex' using the formula : word.charAt(0) - 'A' (line 72)
 	for eg. if word is 'NOTE', we'll find index of 'N' by : 'N' - 'A' = required
 	index of 'N'.
 	eg no. 2, if word is 'B', then it will be : 'B' - 'A' = 68 - 67 = 1 which is
 	the required index for letter 'B'.
 
 	3.2 store the element corresponding to the ChildIndex in a TrieNode variable,
 	say, 'child' (line 73)
 
 	3.3 if the child is present, go to step 4
 
 	3.4 if the child is not present, create a 'child' (say) TrieNode; and store
 	this 'child' element in the 'children' (say) ArrayList of root at the
 	childIndex so calculated (line 233 to 237)
  (after that increment the 'childCount' field)
 
 4. induction step :
 
 	call addhelper method and pass (root, word.substring(1)) as arguments. (line 79)
 */
/*---------------------------------x----------------------------algo (for add() )-----------------------------------x-------------------------*/


