package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_배열돌리기3_16935_2 {
    static int N, M, R, S;
    static int[][] map;

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
        }
    }
     st = new StringTokenizer(br.readLine());
     S = Integer.parseInt(st.nextToken());
    

    // 처리
    for (int i = 0; i < R; i++) {
        
        switch(S) {
        case 1:
            first();
            break;
        case 2:
            second();
            break;
        case 3:
            third();
            break;
        case 4:
            fourth();
            break;
        case 5:
            fivth();
            break;
        case 6:
            sixth();
            break;
        }

    }
    
    
    for (int i = 0; i < map.length; i++) {

        for (int j = 0; j < map[0].length; j++) {
            System.out.print(map[i][j] + " ");
        }
        System.out.println();
    }

}

static void first() {
    for (int i = 0; i < N / 2; i++) {
        for (int j = 0; j < M; j++) {
            int temp = map[i][j];
            map[i][j] = map[N - i - 1][j];
            map[N - i - 1][j] = temp;
        }
    }
}

static void second() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M / 2; j++) {
            int temp = map[i][j];
            map[i][j] = map[i][M - j - 1];
            map[i][M - j - 1] = temp;
        }
    }
}

static void third() {
    int[][] rotate = new int[map[0].length][map.length];
    for (int i = 0; i < rotate.length; i++) {
        for (int j = 0; j < rotate[i].length; j++) {
            rotate[i][j] = map[N - 1 - j][i];
        }
    }

    map = rotate;
}

static void fourth() {
    int[][] rotate = new int[map[0].length][map.length];
    for (int i = 0; i < rotate.length; i++) {
        for (int j = 0; j < rotate[i].length; j++) {
            rotate[i][j] = map[j][M - 1 - i];
        }
    }

    map = rotate;
}
static void fivth() {
    
    int borderX = N / 2;
    int borderY = M / 2;
    int[][] temp = new int[borderX][borderY];

    
    
    // 4번 복사
    for (int i = 0; i < borderX; i++) {
        for (int j = 0; j < borderY; j++) {
            temp[i][j] = map[i + borderX][j];
        }
    }
    
  
    // 3 -> 4
    for (int i = borderX; i < N; i++) {
        for (int j = 0; j < borderY; j++) {
            map[i][j] = map[i][j + borderY];
        }
    }
   
    // 2 -> 3
    for (int i = borderX; i < N; i++) {
        for (int j = borderY; j < M; j++) {
            map[i][j] = map[i - borderX][j];
        }
    }
    
    // 1 -> 2
    for (int i = 0; i < borderX; i++) {
        for (int j = borderY; j < M; j++) {
            map[i][j] = map[i][j - borderY];
        }
    }
    
    // temp -> 1
    for (int i = 0; i < borderX; i++) {
      for (int j = 0; j < borderY; j++) {
          map[i][j] = temp[i][j];
      }
    }
    
    
}

static void sixth() {
    int borderX = N / 2;
    int borderY = M / 2;
    int[][] temp = new int[borderX][borderY];

    for (int i = 0; i < borderX; i++) {
        for (int j = 0; j < borderY; j++) {
            temp[i][j] = map[i][j];
        }
    }

    for (int i = 0; i < borderX; i++) {
        for (int j = 0; j < borderY; j++) {
            map[i][j] = map[i][borderY + j];
        }
    }

    for (int i = 0; i < borderX; i++) {
        for (int j = borderY; j < M; j++) {
            map[i][j] = map[borderX + i][j];
        }
    }

    for (int i = borderX; i < N; i++) {
        for (int j = borderY; j < M; j++) {
            map[i][j] = map[i][j - borderY];
        }
    }

    for (int i = borderX; i < N; i++) {
        for (int j = 0; j < borderY; j++) {
            map[i][j] = temp[i - borderX][j];
        }
    }
}
}