package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    private Canvas canvas;
    private GraphicsContext gc;

    private double lastX;
    private double lastY;

    @FXML
    public void initialize() {
        ToggleGroup toolGroup = new ToggleGroup();
        penRadioButton.setToggleGroup(toolGroup);
        eraserRadioButton.setToggleGroup(toolGroup);
        penRadioButton.setSelected(true);

        canvas = new Canvas();

        canvas.widthProperty().bind(drawingAreaPane.widthProperty());
        canvas.heightProperty().bind(drawingAreaPane.heightProperty());

        drawingAreaPane.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(this::drawingAreaMousePressed);
        canvas.setOnMouseDragged(this::drawingAreaMouseDragged);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawingAreaMousePressed(MouseEvent event) {
        lastX = event.getX();
        lastY = event.getY();

        if (eraserRadioButton.isSelected()) {
            eraseAt(lastX, lastY);
        } else {
            drawLine(lastX, lastY, lastX, lastY);
        }
    }

    private void drawingAreaMouseDragged(MouseEvent event) {
        double currentX = event.getX();
        double currentY = event.getY();

        if (eraserRadioButton.isSelected()) {
            eraseLine(lastX, lastY, currentX, currentY);
        } else {
            drawLine(lastX, lastY, currentX, currentY);
        }

        lastX = currentX;
        lastY = currentY;
    }

    private void drawLine(double x1, double y1, double x2, double y2) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(4);
        gc.setLineCap(StrokeLineCap.ROUND);
        gc.strokeLine(x1, y1, x2, y2);
    }

    private void eraseAt(double x, double y) {
        double size = 24;
        gc.clearRect(x - size / 2, y - size / 2, size, size);
    }

    private void eraseLine(double x1, double y1, double x2, double y2) {
        double eraserSize = 24;

        double dx = x2 - x1;
        double dy = y2 - y1;
        double distance = Math.sqrt(dx * dx + dy * dy);

        int steps = Math.max(1, (int) distance);

        for (int i = 0; i <= steps; i++) {
            double t = (double) i / steps;
            double x = x1 + dx * t;
            double y = y1 + dy * t;

            gc.clearRect(
                    x - eraserSize / 2,
                    y - eraserSize / 2,
                    eraserSize,
                    eraserSize
            );
        }
    }
}