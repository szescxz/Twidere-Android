/*
 *                 Twidere - Twitter client for Android
 *
 *  Copyright (C) 2012-2015 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.api.twitter.api;

import org.mariotaku.restfu.annotation.method.GET;
import org.mariotaku.restfu.annotation.method.POST;
import org.mariotaku.restfu.annotation.param.KeyValue;
import org.mariotaku.restfu.annotation.param.Param;
import org.mariotaku.restfu.annotation.param.Path;
import org.mariotaku.restfu.annotation.param.Queries;
import org.mariotaku.restfu.annotation.param.Query;
import org.mariotaku.restfu.http.BodyType;
import org.mariotaku.twidere.api.twitter.TwitterException;
import org.mariotaku.twidere.api.twitter.model.ConversationTimeline;
import org.mariotaku.twidere.api.twitter.model.NewDm;
import org.mariotaku.twidere.api.twitter.model.Paging;
import org.mariotaku.twidere.api.twitter.model.ResponseCode;
import org.mariotaku.twidere.api.twitter.model.UserInbox;


@Queries(@KeyValue(key = "include_groups", value = "true"))
public interface PrivateDirectMessagesResources extends PrivateResources {

    @POST("/dm/conversation/{conversation_id}/delete.json")
    @BodyType(BodyType.FORM)
    ResponseCode destroyDirectMessagesConversation(@Path("conversation_id") String conversationId) throws TwitterException;

    @POST("/dm/new.json")
    ResponseCode sendDm(@Param NewDm newDm) throws TwitterException;

    @POST("/dm/conversation/{account_id}-{user_id}/delete.json")
    @BodyType(BodyType.FORM)
    ResponseCode destroyDirectMessagesConversation(@Path("account_id") long accountId, @Path("user_id") long userId) throws TwitterException;

    @GET("/dm/user_inbox.json")
    UserInbox getUserInbox(@Query Paging paging) throws TwitterException;

    @GET("/dm/conversation/{conversation_id}.json")
    ConversationTimeline getUserInbox(@Path("conversation_id") String conversationId, @Query Paging paging) throws TwitterException;
}
