// package com.coffeeisoxygen.scoring;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Objects;
// import java.util.PriorityQueue;
// import java.util.Set;

// public class Pathfinding {
// private static final int SAFE = 0; // SafeTile
// private static final int DANGER = 1; // DangerTile
// private static final int ROUTE = 2; // RouteTile

// private int[][] grid; // Grid untuk papan permainan
// private int startX, startY, endX, endY;
// private int boardWidth, boardHeight;

// public Pathfinding(int width, int height) {
// boardWidth = width;
// boardHeight = height;
// grid = new int[boardWidth][boardHeight];
// // Inisialisasi grid dengan beberapa tile (Safe, Danger, Route)
// }

// // Fungsi untuk menentukan heuristic (misalnya, Manhattan Distance)
// private int heuristic(int x, int y) {
// return Math.abs(x - endX) + Math.abs(y - endY); // Manhattan distance
// }

// // Menghitung skor berdasarkan langkah dan penalti untuk DangerTile
// private double calculateScore(int steps, int dangerCount) {
// // Skor lebih tinggi jika jumlah langkah lebih sedikit dan lebih sedikit
// // melewati DangerTile
// double efficiency = 100.0 - (steps * 0.5); // Penalti untuk langkah
// double dangerPenalty = dangerCount * 10.0; // Penalti untuk DangerTile
// double score = Math.max(0, efficiency - dangerPenalty); // Skor tidak boleh
// negatif
// return score;
// }

// // A* pathfinding dengan perhitungan skor
// public List<Tile> findPath() {
// PriorityQueue<Node> openList = new
// PriorityQueue<>(Comparator.comparingInt(node -> node.f));
// Set<Node> closedList = new HashSet<>();
// List<Tile> path = new ArrayList<>();

// // Mulai dari titik start
// Node startNode = new Node(startX, startY, 0, heuristic(startX, startY), null,
// 0, 0);
// openList.add(startNode);

// while (!openList.isEmpty()) {
// Node currentNode = openList.poll();
// int x = currentNode.x;
// int y = currentNode.y;

// // Jika mencapai tujuan
// if (x == endX && y == endY) {
// // Rekonstruksi jalur
// Node current = currentNode;
// int totalSteps = 0;
// int totalDanger = 0;
// while (current != null) {
// path.add(new Tile(current.x, current.y, ROUTE));
// if (grid[current.x][current.y] == DANGER) {
// totalDanger++;
// }
// totalSteps++;
// current = current.parent;
// }
// Collections.reverse(path); // Membalikkan jalur agar sesuai urutannya

// // Hitung skor berdasarkan langkah dan jumlah DangerTile yang dilalui
// double score = calculateScore(totalSteps, totalDanger);
// System.out.println("Score: " + score + "%");

// return path;
// }

// closedList.add(currentNode);

// // Cek tetangga (atas, bawah, kiri, kanan)
// for (int[] dir : new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }) {
// int newX = x + dir[0];
// int newY = y + dir[1];

// if (isInBounds(newX, newY) && !closedList.contains(new Node(newX, newY, 0, 0,
// null, 0, 0))) {
// int tileType = grid[newX][newY];
// if (tileType == DANGER) {
// continue; // Lewati DangerTile
// }

// int g = currentNode.g + 1; // Biaya bergerak ke tetangga
// int h = heuristic(newX, newY);
// Node neighbor = new Node(newX, newY, g, h, currentNode,
// currentNode.dangerCount, currentNode.steps);

// // Jika melewati DangerTile, tambahkan penalti
// if (tileType == DANGER) {
// neighbor.dangerCount++;
// }

// openList.add(neighbor);
// }
// }
// }
// return path; // Jika tidak ada jalur ditemukan
// }

// // Mengecek apakah titik berada dalam batas grid
// private boolean isInBounds(int x, int y) {
// return x >= 0 && x < boardWidth && y >= 0 && y < boardHeight;
// }

// // Tile untuk menyimpan koordinat dan jenis tile
// private static class Tile {
// int x, y, type;

// Tile(int x, int y, int type) {
// this.x = x;
// this.y = y;
// this.type = type;
// }
// }

// // Node untuk A* yang menyimpan informasi posisi, biaya, langkah, dan jumlah
// // DangerTile
// private static class Node {
// int x, y, g, h;
// Node parent;
// int f;
// int dangerCount;
// int steps;

// Node(int x, int y, int g, int h, Node parent, int dangerCount, int steps) {
// this.x = x;
// this.y = y;
// this.g = g; // Biaya dari start ke node
// this.h = h; // Heuristic (perkiraan biaya menuju tujuan)
// this.parent = parent;
// this.dangerCount = dangerCount; // Menghitung jumlah DangerTile yang dilalui
// this.steps = steps; // Menghitung langkah yang telah diambil
// this.f = g + h; // Total biaya (g + h)
// }

// // Override equals dan hashCode untuk perbandingan yang benar
// @Override
// public boolean equals(Object obj) {
// if (obj == null)
// return false;
// if (this == obj)
// return true;
// if (getClass() != obj.getClass())
// return false;
// Node other = (Node) obj;
// return this.x == other.x && this.y == other.y;
// }

// @Override
// public int hashCode() {
// return Objects.hash(x, y);
// }
// }

// public static void main(String[] args) {
// Pathfinding pathfinding = new Pathfinding(10, 10);
// pathfinding.startX = 0;
// pathfinding.startY = 0; // Titik awal
// pathfinding.endX = 9;
// pathfinding.endY = 9; // Titik tujuan

// // Menginisialisasi grid (ini hanya contoh, kamu bisa sesuaikan dengan tile
// yang
// // diinginkan)
// pathfinding.grid[9][9] = SAFE; // Titik tujuan adalah SafeTile
// pathfinding.grid[0][0] = ROUTE; // Titik awal adalah RouteTile

// // Menggunakan A* untuk menemukan jalur
// List<Tile> path = pathfinding.findPath();

// // Menampilkan jalur yang ditemukan
// for (Tile tile : path) {
// System.out.println("Tile at (" + tile.x + ", " + tile.y + ")");
// }
// }
// }
// Compare this snippet from
// hikinggame/src/main/java/com/coffeeisoxygen/model/tiles/Tile.java:

// TODO: Implement the Tile class