package com.coffeeisoxygen.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.model.tiles.TileType;
import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class MapPanel extends JPanel {
    private BoardViewModel viewModel;
    private JButton[][] buttons;

    public MapPanel(BoardViewModel viewModel) {
        this.viewModel = viewModel;
        initializeButtons();
    }

    private void initializeButtons() {
        int width = viewModel.getBoardWidth();
        int height = viewModel.getBoardHeight();
        this.buttons = new JButton[width][height];

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                JButton button = createButton(i, j);
                buttons[i][j] = button;
                gbc.gridx = i;
                gbc.gridy = j;
                add(button, gbc);
            }
        }
    }

    private JButton createButton(int i, int j) {
        JButton button = new JButton(i + "," + j);
        button.setBackground(getTileColor(viewModel.getTile(i, j)));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shuffleTileType(i, j);
            }
        });
        return button;
    }

    private Color getTileColor(Tile tile) {
        if (tile == null) {
            return Color.WHITE;
        }
        return switch (tile.getTileType()) {
            case STARTTILE -> Color.GREEN;
            case FINISHTILE -> Color.RED;
            case SAFETILE -> Color.BLUE;
            case DANGERTILE -> Color.ORANGE;
            case ROUTETILE -> Color.GRAY;
            default -> Color.WHITE;
        };
    }

    private void shuffleTileType(int x, int y) {
        Tile tile = viewModel.getTile(x, y);
        if (tile != null) {
            // Acak TileType (Selain STARTTILE dan FINISHTILE)
            TileType newTileType = randomizeTileType();
            viewModel.setTile(x, y, newTileType); // Update di viewModel
            buttons[x][y].setBackground(getTileColor(viewModel.getTile(x, y))); // Update tampilan tombol
        }
    }

    private TileType randomizeTileType() {
        // Mengacak antara DANGERTILE, SAFETILE, dan ROUTETILE
        TileType[] tileTypes = { TileType.DANGERTILE, TileType.SAFETILE, TileType.ROUTETILE };
        int randomIndex = (int) (Math.random() * tileTypes.length);
        return tileTypes[randomIndex];
    }

    public void refresh() {
        int width = viewModel.getBoardWidth();
        int height = viewModel.getBoardHeight();

        // Reinitialize buttons jika ukuran board berubah
        if (buttons.length != width || buttons[0].length != height) {
            removeAll();
            initializeButtons();
        } else {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    buttons[i][j].setBackground(getTileColor(viewModel.getTile(i, j)));
                }
            }
        }

        revalidate();
        repaint();
    }
}
