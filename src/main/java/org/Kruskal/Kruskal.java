package org.Kruskal;

import java.util.*;

// Classe Edge pour représenter une arête dans le graphe
class Edge implements Comparable<Edge> {
    private int u;       // Premier sommet de l'arête
    private int v;       // Deuxième sommet de l'arête
    private int weight;  // Poids de l'arête

    // Constructeur pour initialiser une arête
    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    // Getter pour obtenir le premier sommet
    public int getU() {
        return u;
    }

    // Getter pour obtenir le deuxième sommet
    public int getV() {
        return v;
    }

    // Getter pour obtenir le poids de l'arête
    public int getWeight() {
        return weight;
    }

    // Méthode pour comparer les arêtes par leur poids
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

// Classe Kruskal pour implémenter l'algorithme de Kruskal
public class Kruskal {
    private int numVertices;  // Nombre de sommets dans le graphe
    private int numEdges;     // Nombre d'arêtes dans le graphe
    private int[] parent;     // Tableau pour l'union-find
    private int[] rank;       // Tableau pour l'union-find optimisé par rang
    private ArrayList<Edge> edges;  // Liste des arêtes du graphe
    private ArrayList<Edge> mst;    // Liste des arêtes de l'arbre couvrant minimal (MST)

    // Constructeur pour initialiser le graphe
    public Kruskal(int numVertices, int numEdges, ArrayList<Edge> edges) {
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        this.edges = edges;
        this.mst = new ArrayList<Edge>();
        this.parent = new int[numVertices];
        this.rank = new int[numVertices];
    }

    // Méthode pour initialiser les ensembles (make-set)
    public void makeSet(int x) {
        parent[x] = x;
        rank[x] = 0;
    }

    // Méthode pour trouver le représentant de l'ensemble (find)
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Compression de chemin
        }
        return parent[x];
    }

    // Méthode pour réaliser l'union de deux ensembles (union)
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        // Union par rang pour maintenir un arbre équilibré
        if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if (rank[yRoot] > rank[xRoot]) {
            parent[xRoot] = yRoot;
        } else if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }

    // Méthode pour exécuter l'algorithme de Kruskal
    public void kruskal() {
        // Initialisation des ensembles pour chaque sommet
        for (int i = 0; i < numVertices; i++) {
            makeSet(i);
        }

        // Tri des arêtes par poids croissant
        Collections.sort(edges);

        // Parcours des arêtes triées
        for (int i = 0; i < numEdges; i++) {
            Edge e = edges.get(i);
            int x = find(e.getU());
            int y = find(e.getV());

            // Si les sommets des deux extrémités de l'arête appartiennent à des ensembles différents
            if (x != y) {
                mst.add(e);    // Ajouter l'arête à l'arbre couvrant minimal
                union(x, y);   // Réaliser l'union des ensembles
            }
        }
    }

    // Méthode pour afficher l'arbre couvrant minimal
    public void printMST() {
        System.out.println("MST: ");
        for (int i = 0; i < mst.size(); i++) {
            System.out.println(mst.get(i).getU() + " " + mst.get(i).getV() + " " + mst.get(i).getWeight());
        }
    }

    // Méthode principale pour exécuter le programme
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Demande à l'utilisateur de saisir le nombre de sommets
        System.out.println("Enter the number of vertices: ");
        int numVertices = sc.nextInt();

        // Demande à l'utilisateur de saisir le nombre d'arêtes
        System.out.println("Enter the number of edges: ");
        int numEdges = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<Edge>();

        // Demande à l'utilisateur de saisir les détails de chaque arête
        for (int i = 0; i < numEdges; i++) {
            System.out.println("Enter the source of edge " + i + " : ");
            int u = sc.nextInt();
            System.out.println("Enter the destination of edge " + i + " : ");
            int v = sc.nextInt();
            System.out.println("Enter the source weight of edge " + i + " : ");
            int weight = sc.nextInt();
            System.out.println("Edge " + i + " : " + u + " " + v + " " + weight);
            edges.add(new Edge(u, v, weight));
        }

        // Création d'un objet Kruskal et exécution de l'algorithme
        Kruskal k = new Kruskal(numVertices, numEdges, edges);
        k.kruskal();

        // Affichage de l'arbre couvrant minimal
        k.printMST();
    }
}
