public class MainActivity extends AppCompatActivity {
  /// Adding AlanButton variable
  private AlanButton alanButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    /// Defining the project key
    AlanConfig config = AlanConfig.builder().setProjectId("").build();
    alanButton = findViewById(R.id.alan_button);
    alanButton.initWithConfig(config);

    AlanCallback alanCallback = new AlanCallback() {
      /// Handling commands from Alan Studio
      @Override
      public void onCommand(final EventCommand eventCommand) {
        try {
          JSONObject command = eventCommand.getData();
          String commandName = command.getJSONObject("data").getString("command");
          Log.d("AlanButton", "onCommand: commandName: " + commandName);
        } catch (JSONException e) {
          Log.e("AlanButton", e.getMessage());
        }
      }
    };

    /// Registering callbacks
    alanButton.registerCallback(alanCallback);
  }
}
