public class JeffBotLauncher {

    private final MainframeDialog dialog;
    private final MainframeModel model;
    private final MainframeController controller;

    public JeffBotLauncher() {
        dialog = new MainframeDialog();
        model = new MainframeModel();
        controller = new MainframeController(dialog, model);
    }

    public void initialize() {
        dialog.setVisible(true);
    }
}
