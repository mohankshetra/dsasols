class Solution {
    public boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");

        int slots = 1;

        for (String node : nodes) {

            // No place available for this node
            if (slots == 0) {
                return false;
            }

            // Current node occupies one slot
            slots--;

            // Non-null node creates two child slots
            if (!node.equals("#")) {
                slots += 2;
            }
        }

        return slots == 0;
    }
}