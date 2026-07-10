public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encoder(root, sb);
        return sb.toString();
    }

    private void encoder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");    
            return;
        }
        sb.append(root.val).append(",");  
        encoder(root.left, sb);
        encoder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(",")));
        return decoder(tokens);
    }

    private TreeNode decoder(Queue<String> tokens) {
        String val = tokens.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = decoder(tokens);
        root.right = decoder(tokens);
        return root;
    }
}