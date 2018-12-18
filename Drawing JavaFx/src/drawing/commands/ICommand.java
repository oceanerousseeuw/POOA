package drawing.commands;

public interface ICommand {

	public void execute();
	public void undo();
}
