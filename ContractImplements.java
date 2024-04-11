import java.util.ArrayList;

public class ContractImplements implements Contract{

    public ContractImplements(){

    }
    public ArrayList<String> inventory = new ArrayList<>();
    public ArrayList<String> commandList = new ArrayList<>();
    public int xCoordinate = 0;
    public int yCoordinate = 0;
    public int currentSize = 100;

   /**
    * @param item
    * adds item to inventory
    * adds command to commandList
    */
     @Override
    public void grab(String item) {
        // TODO Auto-generated method stub
        System.out.println("Grabbing " + item);
        inventory.add(item);
        commandList.add("Grab " + item);
    }
    /**
    * @param item
    * drops item from inventory
    * adds command to commandList
    */
    @Override
    public String drop(String item) {
        // TODO Auto-generated method stub
        if (inventory.contains(item)) {
            System.out.println("Dropping " + item);
            commandList.add("Drop " + item);
        } else {
            System.out.println("You are not holding " + item + ".");
        }
        return null;
    }
    /**
    * @param item
    * prints confirmation of examination if item exists or not
    * adds command to commandList if item exists
    */
    @Override
    public void examine(String item) {
        if (inventory.contains(item)) {
            System.out.println("Examining " + item + ". Wow. This is great.");
            commandList.add("Examine" + item);
        } else {
            System.out.println("I am not sure what I am supposed to be examining");
        }
    
    }
    /**
    * @param item
    * prints confirmation of use if item exists or not
    * adds command to commandList if item exists
    */
    @Override
    public void use(String item) {
        if (inventory.contains(item)) {
            System.out.println("Using " + item + ".");
            commandList.add("Use" + item);
        } else {
            System.out.println("I cannot use an item I do not have.");
        }
    }
    /**
     * prints statement about walking in direction. 
     * Adds command to commandList
     */
    @Override
    public boolean walk(String direction) {
        System.out.println("Walking " + direction);
        commandList.add("Walk " + direction);
        return false;
    }

    /**
     * @param x
     * @param y
     * prints statement about flying in certain direction units. 
     * adds command to commandList
     */
    @Override
    public boolean fly(int x, int y) {
    // TODO Auto-generated method stub
    System.out.println("Flying " + x +" units left and " + y + " units up");
    commandList.add("Fly " + x +" units left and " + y + " units up");
    return false;
    }
    /**
     * prints statement about growing. 
     * updates currentSize
     * adds command to commandList
     * prints statement about size
     * @return currentSize
     */
    @Override
    public Number shrink() {
        // TODO Auto-generated method stub
        currentSize = currentSize - 5;
        System.out.println("Shrinking! You just got smaller.");
        commandList.add("Shrink");
        System.out.println("You are size " + currentSize);
        return currentSize;
    }
    /**
     * prints statement about shrinking. 
     * updates currentSize
     * adds command to commandList
     * prints statement about size
     * @return currentSize
     */
    @Override
    public Number grow() {
        // TODO Auto-generated method stub
        currentSize = currentSize + 5;
        System.out.println("Growing! You just got bigger.");
        commandList.add("Grow)");
        System.out.println("You are size " + currentSize);
        return currentSize;
    }
    /**
     * prints statement about resting
     * adds command to commandList
     */
    @Override
    public void rest() {
        // TODO Auto-generated method stub
        System.out.println("Resting...");
        commandList.add("Rest");
    }
    /**
     * undos previous command
     */
    @Override
    public void undo() {
        if (!commandList.isEmpty()) {
            String lastCommand = commandList.remove(commandList.size() - 1);
            System.out.println("Undoing " + lastCommand);
            if (lastCommand.startsWith("Grab")) {
                String item = lastCommand.substring(5); // Extract item name from command
                drop(item);
            }
            if (lastCommand.startsWith("Drop")) {
                String item = lastCommand.substring(5);
                grab(item);
            }
            if (lastCommand.startsWith("Examine")) {
                System.out.println("Undoing 'Examine'");
            }
            if (lastCommand.startsWith("Use")) {
                System.out.println("Undoing 'Use'");
            }
            if (lastCommand.startsWith("Walk ")) {
                System.out.println("Walking backwards...");
            }
            if (lastCommand.startsWith("Shrink")) {
                System.out.println("Undoing 'Shrink.' Getting bigger now");
            }
            if (lastCommand.startsWith("Grow")) {
                System.out.println("Undoing 'Grow.' Getting smaller now");
            }
            if (lastCommand.startsWith("Rest")) {
                System.out.println("Okay... unresting I guess");
            }
            if (lastCommand.startsWith("Fly")) {
                System.out.println("Undoing 'Fly'");
            }
        } else {
            System.out.println("No commands to undo.");
        }
        commandList.add("Undo");
    }
    // Used chatgpt to help me start the undo command 

    /**
     * 
     * @return inventory
     */
    public ArrayList<String> printInventory(){
    System.out.println(inventory);
        return inventory;
    }
    /**
     * 
     * @return commandList
     */
    public ArrayList<String> printCommandList(){
        System.out.println(commandList);
        return commandList;
    }
    /**
     * creats new implemented contract
     * @param args
     */
        public static void main(String[] args) {
            
        ContractImplements contract = new ContractImplements();
        contract.grab("cup");
        contract.printInventory();
        contract.undo();
        contract.shrink();
        contract.grab("pencil");
        contract.grab("bottle of water");
        contract.grab("ladybug");
        contract.drop("ladybug");
        contract.printInventory();
        contract.printCommandList();
    }
}