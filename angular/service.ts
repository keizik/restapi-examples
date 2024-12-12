import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Headers } from "../shared/headers";
import { Article } from "./article";

@Injectable()
export class ArticleService {
  constructor(private http: HttpClient) { }

  private articlesUrl = "/api/article"; // URL to web api

  public getArticles(): Promise<Article[]> {
    return this.http
      .get<Article[]>(this.articlesUrl, Headers.get)
      .toPromise()
      .catch(this.handleError);
  }

  public getArticle(id: number): Promise<Article> {
    return this.getArticleObservable(id)
      .toPromise()
      .catch(this.handleError);
  }

  public getArticleObservable(id: number) {
    return this.http.get<Article>(`${this.articlesUrl}/${id}`, Headers.get);
  }

  public getTitles(): Observable<string[]> {
    return this.http.get<string[]>(this.articlesUrl + "/titles", Headers.get);
  }

  public getByTitle(title: String): Observable<Article> {
    return this.http.get<Article>(this.articlesUrl + "/title/" + title, Headers.get);
  }

  public update(article: Article): Promise<Article> {
    const url = `${this.articlesUrl}/${article.id}`;
    return this.http
      .put<Article>(url, JSON.stringify(article), Headers.post)
      .toPromise()
      .then(() => article)
      .catch(this.handleError);
  }

  public create(titleParam: string): Promise<Article> {
    return this.http
      .post<Article>(
        this.articlesUrl,
        JSON.stringify({ title: titleParam }),
        Headers.post
      )
      .toPromise()
      .catch(this.handleError);
  }

  public delete(id: number): Promise<void> {
    const url = `${this.articlesUrl}/${id}`;
    return this.http
      .delete(url, Headers.post)
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }
}
